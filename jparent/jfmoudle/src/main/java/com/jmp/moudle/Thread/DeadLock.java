package com.jmp.moudle.Thread;

public class DeadLock implements Runnable{

    private String tag;
    private static Object oneLock = new Object();
    private static Object twoLock = new Object();

    public void setTag(String tag) {
        this.tag = tag;
    }


    @Override
    public void run() {
        if ("One".equals(tag)) {
            synchronized (oneLock) {
                System.err.println("Thread Name :" + Thread.currentThread().getName() + "  in oneLock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (twoLock) {
                    System.err.println("Thread Name :" + Thread.currentThread().getName() + "  in twoLock.");
                }
            }
        }
        if ("Two".equals(tag)) {
            synchronized (twoLock) {
                System.err.println("Thread Name :" + Thread.currentThread().getName() + "  in twoLock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (oneLock) {
                    System.err.println("Thread Name :" + Thread.currentThread().getName() + "  in oneLock.");
                }
            }
        }
    }


    public static void main(String[] args) {
        DeadLock one = new DeadLock();
        one.setTag("One");
        DeadLock two = new DeadLock();
        two.setTag("Two");


        Thread thread1 = new Thread(one, "k1");
        Thread thread2 = new Thread(two, "k2");

        thread1.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();

    }




}
