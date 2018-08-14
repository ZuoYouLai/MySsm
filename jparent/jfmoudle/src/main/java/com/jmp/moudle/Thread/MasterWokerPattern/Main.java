package com.jmp.moudle.Thread.MasterWokerPattern;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //实际开发中多少个线程最好写成Runtime.getRuntime().availableProcessors()
        Master master = new Master(new MyWorker(), 10);
//        Master master = new Master(new Worker(), 10);
        /**
         * 15  4437
         * 10  5878
         * 30  2098
         */
        Random random = new Random();
        for (int k = 0; k <= 100; k++) {
            Task task = new Task();
            task.setId(k);
            task.setName("task" + k);
            task.setPrice(random.nextInt(10000));
            master.submit(task);
        }
        master.execute();
        long start = System.currentTimeMillis();
        while (true) {
            if (master.isComplete()) {
                long end = System.currentTimeMillis()-start;
//                int ret = master.getResult();
                String ret = master.getStrResult();
                System.err.println("计算结果 : " + ret + ",执行耗时:" + end);
                break;
            }
        }
    }
}
