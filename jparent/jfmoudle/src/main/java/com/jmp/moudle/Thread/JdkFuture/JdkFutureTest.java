package com.jmp.moudle.Thread.JdkFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class JdkFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Long start = System.currentTimeMillis();
        FutureTask<String> futureTask = new FutureTask<String>(new RealData("Mr.SamLai"));
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //执行FutureTask，发送请求
        //在这里开启线程进行RealData的call()执行
        executorService.submit(futureTask);
        System.err.println("请求完毕");
        System.err.println("返回的结果为:" + futureTask.get());
        Long end = System.currentTimeMillis();
        System.err.println("总耗时为 : " + (end - start) + "ms");
    }
}
