package com.jmp.controller;

import com.jmp.comm.RequestHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asp")
@Slf4j
public class AspectController {

    @RequestMapping(value = {"/info"})
    public String info(String name) {
        for (int k=0;k<10;k++) {
            log.info("info message {}", k);
            RequestHolder.add("info message " + k);
        }
        return "info log";
    }


    @RequestMapping(value = {"/error"})
    public String error(String name) {
        for (int k=0;k<10;k++) {
            log.info("info message {}", k);
            if (k == 5) {
                int z = 9 / 0;
            }
            RequestHolder.add("info message " + k);
        }
        return "info log";
    }


    @RequestMapping(value = {"/around"})
    public String around(String name) {
        for (int k=0;k<10;k++) {
            log.info("info message {}", k);
            RequestHolder.add("info message " + k);
        }
        return "info log";
    }

}
