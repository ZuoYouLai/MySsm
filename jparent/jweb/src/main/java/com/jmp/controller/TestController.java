package com.jmp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmp.service.UserService;
import com.jmp.sql.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserService userService;


//    @RequestMapping(value = {"/list"}, produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    @RequestMapping(value = {"/list"})
    public String getListData() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> list = userService.getUserList();
        return objectMapper.writeValueAsString(list);
    }

}
