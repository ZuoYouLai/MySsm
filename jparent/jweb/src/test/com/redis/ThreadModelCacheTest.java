package com.redis;

import com.jmp.biz.UserCacheService;
import com.jmp.comm.Enum.CacheEnum;
import com.jmp.comm.Utils.ToolUtils;
import com.jmp.redis.JedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Creator : LaiHaoDa
 * Date    : 2018-08-28 14:02
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@Slf4j
public class ThreadModelCacheTest {


    @Autowired
    private UserCacheService userCacheService;
    @Autowired
    private JedisService jedisService;

    private CountDownLatch countDownLatch = new CountDownLatch(20);

    private final static Integer USER_ID = new Integer(1);

    private final static Integer POOL_SIZE = new Integer(10);


    @Before
    public void before() {
        log.info("delete cache ....");
        String key = ToolUtils.getKey(CacheEnum.SYNLOCK.getKey(), USER_ID);
        jedisService.del(key);
        log.info("delete cache ....   end");
    }


    @Test
    public void threadTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        for(int z=0;z<20;z++) {
            executorService.execute(new SelectTask());
        }
        try {
            //阻塞当前线程
            countDownLatch.await();
            log.info("全部完成查询操作...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //最后关闭线程池
            executorService.shutdown();
        }

        /**
         * 执行的结果： CountDownLatch = 20   pool size = 10
         *             执行一次select 其余都是cache
         * 说明:
         * 并发执行时，一次select 多次 cache
         */
    }


    private class SelectTask implements Runnable {
        @Override
        public void run() {
            userCacheService.lockSynUserCache(USER_ID);
            countDownLatch.countDown();
        }
    }



}

