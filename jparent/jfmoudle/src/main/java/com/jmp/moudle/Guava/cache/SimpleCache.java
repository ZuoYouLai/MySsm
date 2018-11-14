package com.jmp.moudle.Guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-11-14 11:29
 * @ Description：
 */
public class SimpleCache {
    public static void main(String[] args) throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder().build();
        cache.put("lai", "hello guava");
        System.out.println(cache.getIfPresent("lai"));

        System.out.println("==============       =================");

        //设置最大存储
        Cache<String, String> maxNumcache = CacheBuilder.newBuilder().maximumSize(2).build();
        maxNumcache.put("key1","value1");
        maxNumcache.put("key2","value2");
        maxNumcache.put("key3","value3");
        System.out.println("第一个值：" + maxNumcache.getIfPresent("key1"));
        System.out.println("第二个值：" + maxNumcache.getIfPresent("key2"));
        System.out.println("第三个值：" + maxNumcache.getIfPresent("key3"));

        System.out.println("==============       =================");
        //设置过期时间
        Cache<String, String> timecache = CacheBuilder.newBuilder().maximumSize(2).expireAfterWrite(2, TimeUnit.SECONDS).build();
        timecache.put("key1","value1");
        int time = 1;
        while(true) {
            if (timecache.getIfPresent("key1") == null) {
                System.out.println("第" + time++ + "次取到key1的值为：" + timecache.getIfPresent("key1"));
                break;
            }
            System.out.println("第" + time++ + "次取到key1的值为：" + timecache.getIfPresent("key1"));
            Thread.sleep(1000);
        }
        System.out.println("==============       =================");
        //显示清除
        Cache<String, String> delcache = CacheBuilder.newBuilder().build();
        delcache.put("key1","value1");
        delcache.put("key2","value2");
        delcache.put("key3","value3");
        List<String> list = Lists.newArrayList();
        list.add("key1");
        list.add("key2");
        delcache.invalidateAll(list);
        System.out.println("第一个值：" + delcache.getIfPresent("key1"));
        System.out.println("第二个值：" + delcache.getIfPresent("key2"));
        System.out.println("第三个值：" + delcache.getIfPresent("key3"));
        System.out.println("==============       =================");
        //添加一个移除监听器
        System.out.println("==============       =================");
        RemovalListener<String, String> listener = new RemovalListener<String, String>() {
            @Override
            public void onRemoval(RemovalNotification<String, String> notification) {
                System.out.println("[" + notification.getKey() + ":" + notification.getValue() + "] is removed!");
            }
        };
        Cache<String,String> listerCache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .removalListener(listener)
                .build();
        listerCache.put("key1","value1");
        listerCache.put("key2","value2");
        listerCache.put("key3","value3");
        listerCache.put("key4","value3");
        listerCache.put("key5","value3");
        listerCache.put("key6","value3");
        listerCache.put("key7","value3");
        listerCache.put("key8","value3");

        System.out.println("第一个值：" + listerCache.getIfPresent("key1"));
        System.out.println("第二个值：" + listerCache.getIfPresent("key2"));
        System.out.println("第三个值：" + listerCache.getIfPresent("key3"));


        System.out.println("==============       =================");
    }
}
