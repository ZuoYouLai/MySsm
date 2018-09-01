package com.test;

import com.alibaba.fastjson.JSON;
import com.jmp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class OneTest {


    @Resource
    UserService userService;

    @Test
    public void createOneUser() {
        userService.createOneUser();
    }



    @Test
    public void test001() {
        String ke = "46313d38-83f0-4550-b841-e6851e13c3bb";
        System.err.println(JSON.toJSONString(ke));
        System.err.println(ke.length());


    }

}
