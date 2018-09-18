package com.jmp.moudle.Jdk8;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-09-14 16:45
 * @ Description：
 */
public class ThreadTest {
    public static void main(String[] args) {
        new Thread(()->{
            System.err.println("11111111111111 run");
        }).run();


        new Thread(()->{
            System.err.println("222222222222 run");
        }).run();

    }
}
