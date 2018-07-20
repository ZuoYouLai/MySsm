package com.jmp.service.impl;


import com.jmp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class UserServiceImplTest {

    @Resource
    UserService userService;

    @Test
    public void createOneUser() {
        userService.createOneUser();
    }
}
