package com.jmp.biz.impl;

import com.jmp.biz.UserCacheService;
import com.jmp.comm.Enum.CacheEnum;
import com.jmp.comm.Utils.JsonUtil;
import com.jmp.comm.Utils.ToolUtils;
import com.jmp.redis.JedisService;
import com.jmp.service.UserService;
import com.jmp.sql.domain.User;
import com.jmp.sql.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Creator : LaiHaoDa
 * Date    : 2018-08-28 11:24
 */
@Slf4j
@Service("userCacheService")
public class UserCacheServiceImpl implements UserCacheService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JedisService jedisService;





    @Override
    public String simpleUserCache(Integer userId) {
        String key = ToolUtils.getKey(CacheEnum.SIMPLE.getKey(), userId);
        String value = jedisService.get(key);
        if (StringUtils.isNotBlank(value)) {
            log.info("...cache...");
            return value;
        }

        log.info("...select...");
        User user = userMapper.selectByPrimaryKey(userId);
        value = JsonUtil.toJson(user);
        jedisService.set(key, value);
        return value;
    }






    @Override
    public String lockSynUserCache(Integer userId) {
        String key = ToolUtils.getKey(CacheEnum.SYNLOCK.getKey(), userId);
        String value = jedisService.get(key);
        if (StringUtils.isNotBlank(value)) {
            log.info("...cache...");
            return value;
        }
        //spring加载的service 默认是单例 故hashcode是一致的
        log.info("hash code : " + this.hashCode());
        synchronized (this) {
            value = jedisService.get(key);
            if (StringUtils.isNotBlank(value)) {
                log.info("...again cache...");
                return value;
            }
            log.info("...select...");
            User user = userMapper.selectByPrimaryKey(userId);
            value = JsonUtil.toJson(user);
            jedisService.set(key, value);
            return value;
        }
    }






    @Override
    public String lockUserCache(Integer userId) {


        return "";
    }
}
