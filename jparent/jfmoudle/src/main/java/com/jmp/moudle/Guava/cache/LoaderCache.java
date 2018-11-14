package com.jmp.moudle.Guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-11-14 16:12
 * @ Description：
 */
public class LoaderCache {

    public static void main(String[] args) throws ExecutionException {
        CacheLoader<String, String> loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                Thread.sleep(1000); //休眠1s，模拟加载数据
                System.out.println(key + " is loaded from a cacheLoader!");
                return key + "'s value";
            }
        };
        LoadingCache<String,String> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .build(loader);//在构建时指定自动加载器

        System.out.println("第一个值：" + loadingCache.get("key1"));
        System.out.println("第二个值：" + loadingCache.get("key2"));
        System.out.println("第三个值：" + loadingCache.get("key3"));
    }

}
