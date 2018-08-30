package com.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jmp.comm.Utils.JsonUtil;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * Creator : LaiHaoDa
 * Date    : 2018-08-30 13:42
 */
public class CopyBeanTest {


    @Test
    public void copy001() {
        A a = new A();
        a.setAge(1);
        a.setName("a");
        a.setPassword("a password");

        B b = new B();

        BeanUtils.copyProperties(a, b);

        System.err.println(JSON.toJSONString(b));
        //result : {"name":"a"}

    }





    @Test
    public void test002() {

        A a = new A();
        a.setAge(1);
        a.setName("a");
        a.setPassword("a password");

        JSONObject b = new JSONObject();

        BeanUtils.copyProperties(a, b);

        System.err.println(JSON.toJSONString(b));
        //result : {}
    }





    @Test
    public void test003() {

        JSONObject json = new JSONObject();
        json.put("age", 11L);
        json.put("name", "test name");
        json.put("key", "key");
        json.put("password", "password");

        A a = new A();
        B b = new B();

        BeanUtils.copyProperties(json, b);
        BeanUtils.copyProperties(json, a);

        System.err.println(JSON.toJSONString(b));
        //result : {}
        System.err.println(JSON.toJSONString(a));
        //result : {}

        //fastjson json object 转 object
        a = JsonUtil.objectToJson(json, A.class);
        b = JsonUtil.objectToJson(json, B.class);


        //从结果可以看出:int 跟 long 类都转  没有类型的要求 往往很容易出错
        System.err.println(JSON.toJSONString(b));
//        {"age":11,"key":"key","name":"test name"}
        System.err.println(JSON.toJSONString(a));
//        {"age":11,"name":"test name","password":"password"}
    }



}

