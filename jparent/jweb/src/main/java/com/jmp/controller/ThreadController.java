package com.jmp.controller;

import com.jmp.comm.MyThreadPoolExecutor;
import com.jmp.comm.Utils.JsonUtil;
import com.jmp.jpojo.ValidaTestBean;
import com.jmp.service.UserService;
import com.jmp.sql.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import qiniu.ip17mon.LocationInfo;
import qiniu.ip17mon.Locator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/thread")
@Slf4j
public class ThreadController {


    @Resource
    MyThreadPoolExecutor myThreadPoolExecutor;


    @RequestMapping(value = {"/test"})
    public String getListData() throws Exception{
        log.info("thread Test");
        myThreadPoolExecutor.doData();
        return "ok";
    }



}
