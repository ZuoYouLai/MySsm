package com.jmp.comm;

import java.util.ArrayList;
import java.util.List;

public class RequestHolder {
    private final static ThreadLocal<List> threadLocal = new ThreadLocal<>();
    private final static ThreadLocal<Long> timeThreadLocal = new ThreadLocal<>();
    /**
     * 初始化给当前请求链表内容
     */
    public static void init(){
        threadLocal.set(new ArrayList());
        timeThreadLocal.set(System.currentTimeMillis());
    }

    public static void add(Object object){
        threadLocal.get().add(object);
    }

    public static List get(){
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
        timeThreadLocal.remove();
    }

    public static Long getTime(){
        return timeThreadLocal.get();
    }

}
