package com.jmp.controller;

import com.github.pagehelper.PageHelper;
import com.jmp.biz.Config;
import com.jmp.comm.Utils.Constant;
import com.jmp.comm.Utils.JsonUtil;
import com.jmp.comm.Utils.ResultUtils;
import com.jmp.comm.Utils.ToolUtils;
import com.jmp.sql.domain.User;
import com.jmp.sql.domain.UserFile;
import com.jmp.sql.domain.UserFileExample;
import com.jmp.sql.mapper.UserFileMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {


    @Resource
    private Config config;
    @Resource
    private UserFileMapper userFileMapper;



    @RequestMapping(value = {"/list"}, produces = Constant.HTTP_PRODUCE)
    public String getListData() throws Exception{
        UserFileExample example = new UserFileExample();
        example.setOrderByClause("id asc");
        PageHelper.startPage(1, 10);
        List<UserFile> userFiles = userFileMapper.selectByExample(example);
        userFiles.forEach(x -> {
            x.setFilePath(config.getBasePath() + x.getFilePath());
        });
        return ResultUtils.successJSON(userFiles);
    }







    /**
     * file controller方法测试
     * localhost:8888/file/upload
     */
    @RequestMapping(value = {"/upload"})
    @ResponseBody
    public String testParams(@RequestParam MultipartFile file){
        // 获取文件原始名称;
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 新文件名称;
        String newFileName = ToolUtils.getLandingPageCode() + suffix;
        // 保存奖品库存文件;
        String fileUrl = ToolUtils.getSysYearAndMonthAndDay();
        String filePath = config.getLocalFilePath() + File.separator + fileUrl;
        try {
            // 创建文件保存目录;
            Path path = Paths.get(filePath);
            if (!Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
                Files.createDirectories(path);
            }
            file.transferTo(new File(filePath, newFileName));
            String targetPath = fileUrl + "/" + newFileName;
            // 封装返回数据;
            Map<String, Object> dataMap = new HashMap<>();
            UserFile userFile = new UserFile();
            userFile.setFileName(newFileName);
            userFile.setFilePath(targetPath);
            userFileMapper.insertSelective(userFile);
            dataMap.put("path", targetPath);
            return ResultUtils.successJSON(dataMap, "文件上传成功");
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return ResultUtils.failJSON("文件上传失败");
    }


}

