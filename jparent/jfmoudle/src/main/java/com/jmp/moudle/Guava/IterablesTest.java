package com.jmp.moudle.Guava;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Guava之Iterables
 *   有并集 交集 操作
 */
public class IterablesTest {

    public static void main(String[] args) {

        List<String> list = Lists.newArrayList("A", "B", "C");

        Iterable<String> iterables = Iterables.concat(list);

        for (String str : iterables) {
            System.err.println(str);
        }


        //以后Map的初始化跟迭代
        Map<String,String> map = Maps.newHashMap();
        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.err.println(entry.getKey() + "  :  " + entry.getValue());
        }
    }
}
