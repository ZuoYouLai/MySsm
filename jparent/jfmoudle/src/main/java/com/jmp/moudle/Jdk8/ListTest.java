package com.jmp.moudle.Jdk8;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-10-25 11:21
 * @ Description：
 */
public class ListTest {
    public static void main(String[] args) {
        JSONObject one = new JSONObject();
        one.put("size", 11);
        one.put("flag", true);
        one.put("name", "one");
        JSONObject two = new JSONObject();
        two.put("size", 11);
        two.put("flag", false);
        two.put("name", "two");
        JSONArray array = new JSONArray();
        array.add(one);
        array.add(two);
        array.forEach(k->{
            System.err.println(k.toString());
        });


        List<JSONObject> oneList = array.toJavaList(JSONObject.class);
        oneList =oneList.stream().filter(x -> (Objects.equals(x.get("flag"), true))).collect(Collectors.toList());
        oneList.forEach(
                y->System.out.println(y.toJSONString())
        );


        List<String> list = oneList.stream().map(x -> ("`" + x.getString("name") + "`")).collect(Collectors.toList());
        System.err.println("klist   :  " + JSON.toJSONString(list));


        List<JSONObject> jsonObjectList = oneList.stream().filter(y -> y.get("xx") != null).map(x -> {
            JSONObject k = new JSONObject();
            k.put(x.getString("name"), x.get("flag"));
            return k;
        }).collect(Collectors.toList());
        System.err.println("jsonObjectList   :  " + JSON.toJSONString(jsonObjectList));
    }
}
