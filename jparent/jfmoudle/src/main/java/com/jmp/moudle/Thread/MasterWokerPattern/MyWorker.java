package com.jmp.moudle.Thread.MasterWokerPattern;

public class MyWorker extends  Worker {

    public static Object handle(Task executeTask) {
        try {
            Thread.sleep(20);
            return executeTask.getId();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }



}
