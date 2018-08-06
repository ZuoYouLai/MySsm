package com.jmp.comm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;

@Slf4j
public class MyThreadPoolExecutor {

    @Resource
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public void doData() {

        for(int k=0;k<100;k++) {
            threadPoolTaskExecutor.execute(new SqlThread(k,k+99));
        }
    }

}
