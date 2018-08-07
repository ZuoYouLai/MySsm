package com.jmp.quarz;


import com.jmp.comm.Utils.JsonUtil;
import com.jmp.service.UserService;
import com.jmp.sql.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 Spring Quartz 特点：【按照配置文件时间表达式:准时准点(不延时的时候)】  ---> 配置到spring application.xml上
     1. 默认多线程异步执行
     2. 一个任务在上一次调度未完成执行，下一次调度时间到时，会另起一个线程开始新的调度。在业务繁忙时，一个任务或许会有多个线程在执行，导致数据处理异常。
     3. 单任务同步：配置属性，可以使一个任务的一次调度在未完成时，而不会开启下一次调度
     4. 多个任务同时运行，任务之间没有直接的影响，多任务执行的快慢取决于CPU的性能

     一个类对应不一样的job方法并可以定义为不一样的job task任务 [看配置文件内容]

 */
@Component
@Slf4j
public class QuarzJobs {

    @Resource
    UserService userService;

    /**
    * Quarz 运行方法 :  No.1方法
    * 执行的对象是否一致  :  执行的对象是一致的
    */
    public void runOne() {
        log.info("--------> runOne method : {}",this.hashCode());
        log.info("runOne end");
    }


    /**
     * Quarz 运行方法 :  No.2方法
     * 故这个方法没有执行到  :  可以调用相应的service类内容
     */
    public void runTwo() {
        log.info("--------> runTwo method <---------------");
        List<User> list = userService.getUserList();
        log.info(" json data :  {}", JsonUtil.toJson(list));
        log.info("--------> runTwo code : {}",this.hashCode());
        log.info("runTwo end");
    }


    /**
     * Quarz 运行方法 :  No.3方法
     * 当执行error方法时 是否会继续执行任务内容
     * 发生异常的时候则继续执行相应的任务的内容
     */
    public void runThree() {
        log.info("--------> runThree method <---------------");
        Random rand = new Random();
        int num = rand.nextInt();
        if (num % 3 == 0) {
            num = 9 / 0;
        }
        log.info("--------> runThree code : {}",this.hashCode());
        log.info("runThree end");
    }


}
