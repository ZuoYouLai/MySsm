package com.jmp.moudle.Jdk8;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-10-30 14:41
 * @ Description：
 */
public class MapTest {
    public static void main(String[] args) {
        Map one = Maps.newHashMap();
        for(int k=0;k<10;k++) {
            one.put("key" + k, "value" + k);
        }
        one.forEach((key,value)->{
            System.err.println(key + "    :   " + value);
        });
    }
}
