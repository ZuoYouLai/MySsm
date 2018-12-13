package com.japi.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-12-13 14:51
 * @ Description：dubbo服务内容
 */
public interface BaseService {


    /**
     * 针对user - userpoint两张表的操作
     * @param userId
     * @return
     */
    JSONObject doOneUserGroup(Long userId);

}
