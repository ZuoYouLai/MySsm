package com.jmp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loback")
@Slf4j
public class LobackController {

    @RequestMapping(value = {"/info"})
    public String info(String name) {
        for (int k=0;k<10;k++) {
            log.info("info message {}", k);
        }
        return "info log";
    }


    @RequestMapping(value = {"/error"})
    public String error(String name) throws Exception{
        int k = 1 / 0;
        return "error log";
    }



    @RequestMapping(value = {"/console"})
    public String zfTest(String name) {
        log.info("info data");
        log.debug("debug data");
        log.error("info data");
        log.warn("warn data");
        return "console log";
    }

}
