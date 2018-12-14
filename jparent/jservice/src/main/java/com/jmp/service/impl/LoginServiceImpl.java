package com.jmp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jmp.comm.Utils.AESUtil;
import com.jmp.comm.Utils.Constant;
import com.jmp.comm.Utils.ToolUtils;
import com.jmp.service.LoginService;
import com.jmp.sql.domain.Passports;
import com.jmp.sql.domain.PassportsExample;
import com.jmp.sql.mapper.PassportsMapper;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-12-14 17:44
 * @ Description：登录的操作
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private PassportsMapper passportsMapper;


    @Override
    public Passports loginResult(String userName, String password) {
        PassportsExample passportsExample = new PassportsExample();
        passportsExample.createCriteria().andAccountEqualTo(userName);
        List<Passports> list = passportsMapper.selectByExample(passportsExample);
        if (CollectionUtils.isEmpty(list)) {
            ToolUtils.error("用户名不存在");
        }
        Passports target = list.get(0);
        Boolean flag = Objects.equals(target.getPassword(), AESUtil.aesEncode(password, target.getSalt()));
        if (!flag) {
            ToolUtils.error("用户名与密码错误");
        }
        return target;
    }
}
