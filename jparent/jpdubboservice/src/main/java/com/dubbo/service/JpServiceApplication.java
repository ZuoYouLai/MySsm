package com.dubbo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-12-13 17:07
 * @ Description：服务启动类
 */

@Slf4j
public class JpServiceApplication {
    public static void main(String[] args) {
        log.info(">>>>> goodsKill-rpc-service 正在启动 <<<<<");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath*:applicationContext.xml");
        // 程序退出前优雅关闭JVM
        context.registerShutdownHook();
        context.start();
        log.info(">>>>> goodsKill-rpc-service 启动完成 <<<<<");
    }
}
