package com.jmp.moudle.Thread.FuturePattern;

public class FutureTest {
    public static void main(String[] args) {
        FutureClient fc = new FutureClient();
        Long start = System.currentTimeMillis();
        Data data = fc.getRequest("samlai");
        Data data1 = fc.getRequest("MrJm");
        System.err.println("请求完毕....");
        String result = data.getRequest();
        String result1 = data1.getRequest();
        Long end = System.currentTimeMillis();
        System.err.println("总耗时为 : " + (end - start) + "ms");
        System.err.println("返回的结果为 : " + result);
        System.err.println("返回的结果为 : " + result1);
        /**
         代理对象 返回 : com.jmp.moudle.Thread.FuturePattern.FutureData@4517d9a3
         代理对象 返回 : com.jmp.moudle.Thread.FuturePattern.FutureData@372f7a8d
         请求完毕....
         根据参数: MrJm 进行查询，这是一个很耗时的操作！
         根据参数: samlai 进行查询，这是一个很耗时的操作！
         装载完毕，获取结果
         总耗时为 : 3034ms
         返回的结果为 : samlai : A001  [thread name : Thread-0]
         返回的结果为 : MrJm : A001  [thread name : Thread-1]
         装载完毕，获取结果

         多线程future设计模式:
         根据结果：每个request都会开辟一个线程，异步的进行操作各自的任务，时间的总耗时为：较长的request的消耗时间


         */
    }
}
