package com.whut.study.thread.thread.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/17 18:49
 * @desription
 */
public class PrintTest2 {

    public static void main(String[] args) throws InterruptedException {



        for (int i = 0; i < 5; i++) {
            CountDownLatch countDownLatch = new CountDownLatch(3);
            Thread threadM = new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                System.out.println("");
            });
            threadM.start();


            TimeUnit.SECONDS.sleep(1);

            Thread threadA = new Thread(() -> {
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.print("a");

                countDownLatch.countDown();
            });

            Thread threadB = new Thread(() -> {
//                try {
//                    TimeUnit.SECONDS.sleep(4);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.print("b");

                countDownLatch.countDown();
            });

            Thread threadc = new Thread(() -> {
//                try {
//                    TimeUnit.SECONDS.sleep(6);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.print("c");

                countDownLatch.countDown();

            });
            threadA.start();
            threadB.start();
            threadc.start();
        }





    }
}
