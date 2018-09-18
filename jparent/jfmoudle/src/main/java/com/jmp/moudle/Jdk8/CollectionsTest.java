package com.jmp.moudle.Jdk8;

import com.jmp.comm.Utils.JsonUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-09-14 16:49
 * @ Description：
 */
public class CollectionsTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("I", "Study", "Java","A");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                return o1.length() - o2.length();
            }
        });

        System.err.println(JsonUtil.toJson(list));
    }
}
