package com.jmp.disruptor.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-09-12 18:28
 * @ Description：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@Slf4j
public class INotifyServiceImplTest {

    @Resource
    private INotifyService iNotifyService;


    @Test
    public void sendNotify() {

    }
}