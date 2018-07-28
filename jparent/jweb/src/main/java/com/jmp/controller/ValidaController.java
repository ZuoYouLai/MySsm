package com.jmp.controller;

import com.jmp.comm.Utils.JsonUtil;
import com.jmp.jpojo.ValidaTestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/valid")
@Slf4j
public class ValidaController {

    /**
     * valid controller方法测试
     * localhost:8888/valid/test?id=11&name=22&age=-1&content=77
     */
    @RequestMapping(value = {"/test"})
    public String testParams(@RequestBody @Valid ValidaTestBean validaTestBean){
        log.info("valid bean data : {}", JsonUtil.toJson(validaTestBean));
        return "ok";
    }


    /**
     *
     */

}

