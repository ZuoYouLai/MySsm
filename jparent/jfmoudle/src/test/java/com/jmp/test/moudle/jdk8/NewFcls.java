package com.jmp.test.moudle.jdk8;

import com.jmp.comm.Utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 新功能内容
 */
@Slf4j
public class NewFcls {


     /**
        * 线程不同jdk的写法
        */
      @Test
      public void testThread() throws InterruptedException {

          //JDK 8 version
          new Thread(
                  ()->{
                      System.err.println(" jdk 8 version thread...");
                  }
          ).start();

         //JDk 7 version
         new Thread(new Runnable() {
             @Override
             public void run() {
                 System.err.println("common run thread....");
             }
         }).start();

          Thread.sleep(100);

      }


    /**
     *  list比较方法
     */
    @Test
    public void testCompareList() {
        List<String> list = Arrays.asList("I", "Study", "Java","A");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                return o1.length() - o2.length();
            }
        });

        System.err.println(JsonUtil.toJson(list));

        List<String> listT = Arrays.asList("I", "Study", "Java","A");
        Collections.sort(listT,(o1,o2)->{
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            return o1.length() - o2.length();
        });
        System.err.println(JsonUtil.toJson(listT));
    }
}
