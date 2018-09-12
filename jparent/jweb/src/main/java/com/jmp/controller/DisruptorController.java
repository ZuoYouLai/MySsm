package com.jmp.controller;

import com.jmp.disruptor.INotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-09-12 18:32
 * @ Description：
 */
@Slf4j
@RequestMapping("/dis")
public class DisruptorController {


    @Resource
    private INotifyService iNotifyService;


    @ResponseBody
    public String testLog() {
        log.info("=============");
        iNotifyService.sendNotify("Hello,World!");
        return "hello,world";
    }
}
