package com.jmp.qrcontroller;

import com.alibaba.fastjson.JSONObject;
import com.jmp.comm.Utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-12-14 16:23
 * @ Description：
 */
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {


    @RequestMapping(produces = Constant.HTTP_PRODUCE)
    public String getListData(String userName, String password) {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("name", "tag test");
//        if (StringUtils.isNotBlank(flag)) {
//            throw new RuntimeException("标签出现异常啦啦啦");
//        }
//        return jsonObject.toJSONString();

        return "";
    }




}
