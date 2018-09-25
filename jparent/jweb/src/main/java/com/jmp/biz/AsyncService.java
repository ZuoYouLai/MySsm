package com.jmp.biz;

import com.alibaba.fastjson.JSONObject;
import com.jmp.sql.domain.UserPoint;

import java.util.concurrent.Future;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-09-19 15:31
 * @ Description：
 */
public interface AsyncService {


    Future<UserPoint> taskOne();

    Future<UserPoint> taskTwo();

    UserPoint taskThree();

    UserPoint taskFour();


}
