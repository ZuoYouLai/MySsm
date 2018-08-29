package com.jmp.biz.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.jmp.biz.CacheLoadable;
import com.jmp.redis.JedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * Creator : LaiHaoDa
 * Date    : 2018-08-29 17:31
 */
@Service
@Slf4j
public class UserCacheServer {

    @Autowired
    private JedisService jedisService;

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public <T> T queryByCache(String queryKey, long expire,TypeReference<T> typeReference,
                              CacheLoadable<T> cacheLoadable, Integer id) {
        T result;
        readWriteLock.readLock().lock();
        try {
            String value = jedisService.get(queryKey);
            if (StringUtils.isNotBlank(value)) {
                log.info("=========== cache =========");
                result = JSON.parseObject(value, typeReference);
            } else {
                //若缓存读取失败，则需要去数据库中查询
                readWriteLock.readLock().unlock();//释放读锁
                readWriteLock.writeLock().lock();//添加写锁
                try {
                    value = jedisService.get(queryKey);
                    if (StringUtils.isNotBlank(value)) {
                        log.info("=========== two cache =========");
                        result = JSON.parseObject(value, typeReference);
                    }
                    log.info("=========== select =========");
                    result = cacheLoadable.load(id);
                    if (result != null) {
                        jedisService.set(queryKey, JSON.toJSONString(result), "XX", "EX", expire);
                    }
                }finally {
                    readWriteLock.writeLock().unlock();
                    readWriteLock.readLock().lock();
                }
            }
        }finally {
          readWriteLock.readLock().unlock();
        }
        return result;
    }



    /**
     * 存储数据到缓存中，并制定过期时间和当Key存在时是否覆盖。
     *
     * @param key
     * @param value
     * @param nxxx
     *            nxxx的值只能取NX或者XX，如果取NX，则只有当key不存在是才进行set，如果取XX，则只有当key已经存在时才进行set
     *
     * @param expx expx的值只能取EX或者PX，代表数据过期时间的单位，EX代表秒，PX代表毫秒。
     * @param time 过期时间，单位是expx所代表的单位。
     * @return
     */

}
