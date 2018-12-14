package com.jmp.service;

import com.alibaba.fastjson.JSONObject;
import com.jmp.sql.domain.Passports;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-12-14 17:40
 * @ Description：
 */
public interface LoginService {

    Passports loginResult(String userName, String password);
}
