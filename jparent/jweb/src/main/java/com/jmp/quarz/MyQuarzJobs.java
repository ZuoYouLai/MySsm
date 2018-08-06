package com.jmp.quarz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class MyQuarzJobs {

    /**
     * 定时任务方法
     */
    @Scheduled(cron = "0/10 * * * * ? ")
    public void run(){
        log.info("MyQuarzJobs job");
    }

}
