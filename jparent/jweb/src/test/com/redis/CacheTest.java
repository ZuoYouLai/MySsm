package com.redis;

import com.jmp.comm.Enum.CacheEnum;
import com.jmp.comm.Utils.JsonUtil;
import com.jmp.comm.Utils.ToolUtils;
import com.jmp.redis.JedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class CacheTest {

    @Resource
    private JedisService jedisService;


    @Test
    public void test000() {
        String key = ToolUtils.getKey(CacheEnum.SIMPLE.getKey(), 1);
        jedisService.del(key);
    }



    @Test
    public void test001() throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("测试list");
        list.add("测试list2");

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("test*","测试数据");
        map.put("测试数据","啥的");
        map.put("listTest",list);
        jedisService.set("map", JsonUtil.toJson(map));


        System.out.print(jedisService.get("map"));
    }













}
