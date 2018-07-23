package com.jmp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmp.service.UserService;
import com.jmp.sql.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Resource
    UserService userService;


//    @RequestMapping(value = {"/list"}, produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    @RequestMapping(value = {"/list"})
    public String getListData() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> list = userService.getUserList();
        LOG.info("test controller.....");
        return objectMapper.writeValueAsString(list);
    }

}
