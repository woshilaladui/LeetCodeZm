package com.whut.algorithm.thread.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/1 13:54
 * @desription
 */
public class JTest {

    private static boolean flag = true;

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition notFull = lock.newCondition();

        try {
            notFull.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Thread thread = new Thread(() -> {
            while (flag) {
                System.out.println("a");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("errrrrr");
                    flag = false;
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(0);
        } catch (InterruptedException e) {
            System.out.println("hhh");
            e.printStackTrace();
        }
        thread.interrupt();


    }
}
