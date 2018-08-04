package com.jmp.moudle.Guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jmp.comm.Utils.JsonUtil;

import java.util.List;
import java.util.Map;

/**
 * 集合初始化的写法
 *
 */
public class Collections {
    public static void main(String[] args) {

        List<String> list1 = Lists.newArrayList();

        List<String> list2 = Lists.newArrayList("A", "B", "C");

        System.err.println(JsonUtil.toJson(list2));

        Map<String, String> map = Maps.newHashMap();

    }
}
