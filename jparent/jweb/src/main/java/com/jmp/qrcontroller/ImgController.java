package com.jmp.qrcontroller;

import com.github.pagehelper.PageHelper;
import com.jmp.biz.Config;
import com.jmp.comm.Utils.Constant;
import com.jmp.comm.Utils.ResultUtils;
import com.jmp.comm.Utils.ToolUtils;
import com.jmp.sql.domain.UserFile;
import com.jmp.sql.domain.UserFileExample;
import com.jmp.sql.mapper.UserFileMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("/img")
@Slf4j
public class ImgController {


    @Resource
    private Config config;



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
        String newFileName = ToolUtils.getRandStr(9) + suffix;
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
            dataMap.put("path", targetPath);
            log.info("path  :  {}", targetPath);
            return ResultUtils.successJSON(dataMap, "文件上传成功");
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return ResultUtils.failJSON("文件上传失败");
    }


}

