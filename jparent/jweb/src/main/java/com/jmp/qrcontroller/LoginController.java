package com.jmp.qrcontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jmp.comm.Utils.Constant;
import com.jmp.comm.Utils.ResultUtils;
import com.jmp.comm.Utils.ToolUtils;
import com.jmp.redis.JedisService;
import com.jmp.service.LoginService;
import com.jmp.sql.domain.Passports;
import com.jmp.sql.domain.PassportsExample;
import com.jmp.sql.mapper.PassportsMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.tools.Tool;
import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-12-14 16:23
 * @ Description：
 */
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    JedisService jedisService;
    @Autowired
    private LoginService loginService;


    /**
     * method :  post
     * url :  /login
     * @author samLai
     * @date 2018/12/14 18:03
     * @params [userName --> string  , password --> string]
     * @return java.lang.String
     * @Description :登录操作
     */
    @RequestMapping(produces = Constant.HTTP_PRODUCE, method = RequestMethod.POST)
    public String getListData(String userName, String password) {
        Assert.hasText(userName, "用户名不能为空");
        Assert.hasText(password, "密码不能为空");
        Passports result = loginService.loginResult(userName, password);
        String token = ToolUtils.getRandStr(9);
        String key = ToolUtils.getKey(Constant.LOGIN_INDEX, token);
        jedisService.set(key, JSON.toJSONString(result), 5, TimeUnit.HOURS);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("loginTime", new DateTime().toString(Constant.DATE_YMD_HMS));
        jsonObject.put("token", token);
        return ResultUtils.successJSON(jsonObject, "登录成功");
    }




}
