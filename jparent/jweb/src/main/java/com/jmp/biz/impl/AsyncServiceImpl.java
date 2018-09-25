package com.jmp.biz.impl;

import com.alibaba.fastjson.JSONObject;
import com.jmp.biz.AsyncService;
import com.jmp.service.UserPointService;
import com.jmp.sql.domain.UserPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-09-19 15:35
 * @ Description：
 */
@Slf4j
@Service("asyncService")
public class AsyncServiceImpl implements AsyncService {

    @Autowired
    private UserPointService userPointService;

    @Async
    @Override
    public Future<UserPoint> taskOne() {
        String threadName = Thread.currentThread().getName();
        log.info("thread name :  {}", threadName);
        try {
            Thread.sleep(2000L);
        } catch (Exception e){
        }
        UserPoint userPoint=userPointService.decrPoint(2L, 10);
        log.info("task one  desc 10");
        return new AsyncResult<>(userPoint);
    }


    @Async
    @Override
    public Future<UserPoint> taskTwo() {
        String threadName = Thread.currentThread().getName();
        log.info("thread name :  {}", threadName);
        try {
            Thread.sleep(3000L);
        } catch (Exception e){
        }
        UserPoint userPoint = userPointService.incrPoint(2L, 10);
        log.info("task two  desc 20");
        return new AsyncResult<>(userPoint);
    }



    @Override
    public UserPoint taskThree() {
        String threadName = Thread.currentThread().getName();
        log.info("thread name :  {}", threadName);
        try {
            Thread.sleep(2000L);
        } catch (Exception e){
        }
        log.info("task three  desc 10");
        return userPointService.decrPoint(2L, 10);
    }



    @Override
    public UserPoint taskFour() {
        String threadName = Thread.currentThread().getName();
        log.info("thread name :  {}", threadName);
        try {
            Thread.sleep(3000L);
        } catch (Exception e){
        }
        log.info("task four  desc 20");
        return userPointService.incrPoint(2L, 10);
    }
}
