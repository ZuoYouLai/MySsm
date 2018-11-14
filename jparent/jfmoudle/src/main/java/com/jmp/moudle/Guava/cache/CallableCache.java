package com.jmp.moudle.Guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-11-14 15:29
 * @ Description：
 */
public class CallableCache {

    private static Cache<String,String> cache = CacheBuilder.newBuilder()
            .maximumSize(3)
            .build();

    public static void main(String[] args) {

            new Thread(()->{
                System.out.println("thread1");
                try {
                    String value = cache.get("key", new Callable<String>() {
                        @Override
                        public String call() throws Exception {
                            System.out.println("load1"); //加载数据线程执行标志
                            Thread.sleep(1000); //模拟加载时间
                            return "auto load by Callable";
                        }
                    });
                    System.out.println("thread1 " + value);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }).start();


        new Thread(()->{
            System.out.println("thread2");
            try {
                String value = cache.get("key", new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        System.out.println("load2"); //加载数据线程执行标志
                        Thread.sleep(1000); //模拟加载时间
                        return "auto load by Callable";
                    }
                });
                System.out.println("thread2 " + value);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }).start();


        //虽然是两个线程同时调用get方法，但只有一个get方法中的Callable会被执行(没有打印出load2)。Guava可以保证当有多个线程同时访问Cache中的一个key时，如果key对应的记录不存在，Guava只会启动一个线程执行get方法中Callable参数对应的任务加载数据存到缓存。当加载完数据后，任何线程中的get方法都会获取到key对应的值。


    }
}
