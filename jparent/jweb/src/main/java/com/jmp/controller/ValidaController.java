package com.jmp.controller;

import com.jmp.comm.Utils.JsonUtil;
import com.jmp.jpojo.ValidaTestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    public String testParams(@Valid ValidaTestBean validaTestBean){
        log.info("valid bean data : {}", JsonUtil.toJson(validaTestBean));
        return "ok";
    }


    /**
     *
     */
    @RequestMapping(value = {"/reqStr"})
    public String reqStr(@RequestBody String string){
        log.info("valid bean data : {}", string);
        ValidaTestBean validaTestBean = JsonUtil.json2Java(string,ValidaTestBean.class);
        log.info("java bean : ",JsonUtil.toJson(validaTestBean));
        return "ok";
    }
}

