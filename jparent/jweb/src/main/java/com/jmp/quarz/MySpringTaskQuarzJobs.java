package com.jmp.quarz;

import com.jmp.comm.Utils.JsonUtil;
import com.jmp.service.UserService;
import com.jmp.sql.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;


/**
 * spring task的特点:
         1. 默认单线程同步执行
         2. 一个任务执行完上一次之后，才会执行下一次调度
         3. 多任务之间按顺序执行，一个任务执行完成之后才会执行另一个任务
         4. 多任务并行执行需要设置线程池
         5. 全程可以通过注解配置
 */

@Component
@Slf4j
public class MySpringTaskQuarzJobs {

    @Resource
    UserService userService;

    /**
     * 定时任务方法:
     *      不一样的线程进行操作的
     *      注解式的任务,在时间延迟的时候，大于相间隔的时间进行操作的，也会执行完再执行下一个操作
     */
//    @Scheduled(cron = "0/2 * * * * ? ")
    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("run obj info : ",this.hashCode());
        log.info("MyQuarzJobs job");
    }


    /**
     * 注解式的定时任务操作:
     *     当发生异常时，任务在相应的间隔时间进行执行
     */
//    @Scheduled(cron = "0/3 * * * * ? ")
    public void runError(){
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random rand = new Random();
        int num = rand.nextInt();
        if (num % 3 == 0) {
            num = 9 / 0;
        }
        log.info("runError obj info : ",this.hashCode());
        log.info("runError job");
    }


    /**
     * 可以调用相应的服务类内容
     */
//    @Scheduled(cron = "0/5 * * * * ? ")
    public void runService(){
        log.info("--------> runService method <---------------");
        List<User> list = userService.getUserList();
        log.info(" json data :  {}", JsonUtil.toJson(list));
        log.info("--------> runService code : {}",this.hashCode());
        log.info("runService end");
    }



}
