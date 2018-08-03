package com.jmp.moudle.Thread;


/**
 * 多线程 wait 与 notify  例子有待改善
 *
 *
 */
public class WaitNotifyThread {

    public static Object sobj = new Object();

    public static Integer num = 0;

    public static void customerDo() throws InterruptedException {
        while (true) {
            synchronized (sobj) {
                num++;
                if (num == 7) {
                    sobj.wait();
                    System.err.println(" wait ...");
                }
                System.err.println(" cus num : " + num);
                Thread.sleep(500);
            }
        }
    }


    public static void productDo() throws InterruptedException {
        while (true) {
            synchronized (sobj) {
                num++;
                if (num == 13) {
                    sobj.notify();
                    System.err.println(" notify ...");
                }
                System.err.println(" prod num : " + num);
                Thread.sleep(500);
            }
        }
    }

    public static void main(String[] args) {

        new Thread(()->{
            try {
                customerDo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                productDo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

}
