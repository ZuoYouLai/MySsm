package com.jmp.test.moudle.jdk8;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-11-01 16:27
 * @ Description：
 */
public class OneList {

    @Test
    public void test001() {
        Map map = Maps.newHashMap();
        map.put("A", "A集合");
        map.put("B", "B集合");
        DT a = new DT("A", "a");
        DT b = new DT("B", "b");
        DT c = new DT("B", "b");
        DT d = new DT("C", "b");
        List<DT> list = Lists.newArrayList(a, b, c, d);
//        list.clear();
        List<String> strList = list.stream().filter(y -> (map.get(y.getChannel()) != null)).distinct().map(x -> {
            return (String) map.get(x.getChannel());
        }).collect(Collectors.toList());
        System.err.println(JSON.toJSONString(strList));
    }
}


@Data
class DT{
    private String channel;
    private String name;

    public DT(String channel, String name) {
        this.channel = channel;
        this.name = name;
    }
}