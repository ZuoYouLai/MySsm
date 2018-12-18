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
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.tools.Tool;
import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-12-14 16:23
 * @ Description：
 */
@RestController
@Slf4j
public class IndexController {


    @Autowired
    JedisService jedisService;


    /**
     * method :  post
     * url :  /login
     *
     * @return java.lang.String
     * @author samLai
     * @date 2018/12/14 18:03
     * @params [userName --> string  , password --> string]
     * @Description :登录操作
     */
    @RequestMapping(value = {"/logout"}, produces = Constant.HTTP_PRODUCE, method = RequestMethod.GET)
    public String getListData(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (StringUtils.isNotBlank(token)) {
            String loginKey = ToolUtils.getKey(Constant.LOGIN_INDEX, token);
            jedisService.del(loginKey);
        }
        return ResultUtils.successJSON("登出成功");
    }




}
