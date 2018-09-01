package com.jmp.biz;

/**
 * Creator : LaiHaoDa
 * Date    : 2018-08-29 15:02
 */
public interface CacheLoadable<T> {
    T load(Integer id);
}
