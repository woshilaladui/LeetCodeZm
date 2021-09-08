package com.whut.study.thread.thread_list;

import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/31 18:42
 * @desription
 */
public class aaa {
    static CountDownLatch countDownLatch = new CountDownLatch(10);
    private static volatile int a = 0;

    public static void main(String[] args) throws InterruptedException {

        String s = "";


        for (int i = 0; i < 10; i++) {
            countDownLatch = new CountDownLatch(10);
            for (int j = 0; j < 10; j++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ///   synchronized (this) {

                        System.out.println(a);
                        a++;
                        countDownLatch.countDown();
                    }
                    // }

                }).start();
            }

            countDownLatch.await();
            System.out.println("第" + Math.ceil(a / 10) + "组");
        }
    }
}
