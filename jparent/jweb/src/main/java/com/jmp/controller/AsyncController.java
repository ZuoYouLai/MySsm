package com.jmp.controller;

import com.jmp.biz.AsyncService;
import com.jmp.comm.Utils.JsonUtil;
import com.jmp.sql.domain.User;
import com.jmp.sql.domain.UserPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-09-19 15:15
 * @ Description：
 */
@RestController
@RequestMapping("/async")
@Slf4j
public class AsyncController {


    @Autowired
    private AsyncService asyncService;

    //  localhost:8080/async/yb
    @RequestMapping(value = {"/yb"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String doTask() throws Exception {
        log.info("yb controller.....");
        long t1 = System.currentTimeMillis();
        Future<UserPoint> one = asyncService.taskOne();
        Future<UserPoint> two = asyncService.taskTwo();
        log.info("one info :  {}", JsonUtil.toJson(one.get()));
        log.info("two info :  {}", JsonUtil.toJson(two.get()));
        long t2 = System.currentTimeMillis();
        log.info("time 消费 : {}", (t2 - t1));
        return "ok";
    }



    //  localhost:8080/async/tb
    @RequestMapping(value = {"/tb"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String tdoTask() throws Exception {
        log.info("tb controller.....");
        long t1 = System.currentTimeMillis();
        UserPoint three = asyncService.taskThree();
        UserPoint four = asyncService.taskFour();
        long t2 = System.currentTimeMillis();
        log.info("time 消费 : {}", (t2 - t1));
        log.info("one info :  {}", JsonUtil.toJson(three));
        log.info("two info :  {}", JsonUtil.toJson(four));
        return "ok";
    }




    @RequestMapping(value = {"/yb2"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String ybdoTask() throws Exception {
        long t1 = System.currentTimeMillis();
        Future<UserPoint> two = asyncService.taskTwo();
        Future<UserPoint> two1 = asyncService.taskTwo();
        Future<UserPoint> two2 = asyncService.taskTwo();
        Future<UserPoint> two3 = asyncService.taskTwo();
        log.info("two info :  {}", JsonUtil.toJson(two.get()));
        log.info("two1 info :  {}", JsonUtil.toJson(two1.get()));
        log.info("two2 info :  {}", JsonUtil.toJson(two2.get()));
        log.info("two3 info :  {}", JsonUtil.toJson(two3.get()));
        long t2 = System.currentTimeMillis();
        log.info("time 消费 : {}", (t2 - t1));
        return "ok";
    }
}
