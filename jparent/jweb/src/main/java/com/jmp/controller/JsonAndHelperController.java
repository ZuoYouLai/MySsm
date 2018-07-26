package com.jmp.controller;

import com.jmp.comm.ApplicationContextHelper;
import com.jmp.comm.Utils.JsonUtil;
import com.jmp.jpojo.OneBean;
import com.jmp.service.UserService;
import com.jmp.sql.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/test")
@Slf4j
public class JsonAndHelperController {

    /**
     * /test/log
     * lobok的测试
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/log"})
    public String log() throws Exception{
        log.info("lombok test : {}", true);
        log.debug("lombok debug : {}", true);
        List<OneBean> list = Stream.of(
                new OneBean(1,"990"),
                new OneBean(2,"110")
                ).collect(Collectors.toList());
        return JsonUtil.toJson(list);
    }


    /**
     * /test/list
     * helper获取对应的Service
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/list"})
    public String list() throws Exception{
        UserService userService = ApplicationContextHelper.popBean(UserService.class);
        List<User> list = userService.getUserList();
        log.info("spring helper get list  :  {}", JsonUtil.toJson(list));
        return JsonUtil.toJson(list);
    }
}
