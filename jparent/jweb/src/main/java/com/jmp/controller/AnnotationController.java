package com.jmp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jmp.annotation.MyTag;
import com.jmp.comm.Utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-11-30 16:52
 * @ Description：
 */


@RestController
@RequestMapping("/annotation")
@Slf4j
public class AnnotationController {


    @MyTag(tagContent = "tag 内容", tagRole = "角色丁问", tagName = "标签名称")
    @RequestMapping(value = {"/test"}, produces = Constant.HTTP_PRODUCE)
    public String getListData(String flag) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "tag test");
        if (StringUtils.isNotBlank(flag)) {
            throw new RuntimeException("标签出现异常啦啦啦");
        }
        return jsonObject.toJSONString();
    }

}
