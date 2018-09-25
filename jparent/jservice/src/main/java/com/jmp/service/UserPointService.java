package com.jmp.service;

import com.jmp.sql.domain.UserPoint;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-09-19 15:49
 * @ Description：
 */
public interface UserPointService {

    void testInsert();

    UserPoint incrPoint(Long id, Integer point);

    UserPoint decrPoint(Long id, Integer point);

    void testInsert(String name);


}
