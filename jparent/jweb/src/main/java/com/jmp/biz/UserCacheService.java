package com.jmp.biz;


import com.jmp.sql.domain.User;

/**
 * Creator : LaiHaoDa
 * Date    : 2018-08-28 11:23
 */
public interface UserCacheService {


    //简单user select
    String simpleUserCache(Integer userId);


    //加上Syn关键字查询
    String lockSynUserCache(Integer userId);


    //加上读写锁 加锁user select
    String lockUserCache(Integer userId);


    //模版方式 加锁操作
    User templateUserCache(Integer userId);

}
