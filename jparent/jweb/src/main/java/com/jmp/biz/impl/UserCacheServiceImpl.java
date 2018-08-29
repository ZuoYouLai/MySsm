package com.jmp.biz.impl;

import com.jmp.biz.CacheLoadable;
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

import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * Creator : LaiHaoDa
 * Date    : 2018-08-28 11:24
 */
@Slf4j
@Service("userCacheService")
public class UserCacheServiceImpl implements UserCacheService,CacheLoadable<User> {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JedisService jedisService;

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();




    @Override
    public String lockUserCache(Integer userId) {
        String value = "";
        String key = ToolUtils.getKey(CacheEnum.LOCK.getKey(), userId);
        //添加锁
        readWriteLock.readLock().lock();
        try {
            value = jedisService.get(key);
            if (StringUtils.isBlank(value)) {
                //若缓存读取失败，则需要去数据库中查询
                readWriteLock.readLock().unlock();
                readWriteLock.writeLock().lock();
                try {
                    value = jedisService.get(key);
                    if (StringUtils.isBlank(value)) {
                        log.info("...select...");
                        User user = userMapper.selectByPrimaryKey(userId);
                        value = JsonUtil.toJson(user);
                        jedisService.set(key, value);
                    } else {
                        log.info("...lock cache...");
                    }
                }finally {
                    readWriteLock.writeLock().unlock();
                    readWriteLock.readLock().lock();
                }
            } else {
                log.info("...one cache...");
            }
        }finally {
            readWriteLock.readLock().unlock();
        }
        return value;
    }




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
        //jdk8的synchronized性能优化后跟locks锁性能没有多大的区别
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
    public User load(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
