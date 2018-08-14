package com.jmp.moudle.Thread.MasterWokerPattern;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Worker implements Runnable {

    private ConcurrentLinkedDeque<Task> taskQueue;
    private ConcurrentHashMap<String, Object> resultMap;

    public void setTaskQueue(ConcurrentLinkedDeque<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        while (true) {
            Task task = this.taskQueue.poll();
            if (task == null) {
                break;
            }
            //真正的任务处理
            System.err.println(this.getClass().getName());
            String clsName = this.getClass().getSimpleName();
            Object result = null;
            switch (clsName) {
                case "MyWorker":
                    result = MyWorker.handle(task);
                break;
                default:
                    result = handle(task);
            }
            this.resultMap.put(task.getName(), result);
        }
    }

    //核心处理逻辑，可以抽离出来由具体子类实现
    public static Object handle(Task executeTask) {
        Object result = null;
        try {
            //表示处理任务的耗时....
            Thread.sleep(500);
            result = executeTask.getPrice();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
