package com.whut.study.thread.synchronize;

import java.util.Date;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/18 19:36
 * @desription
 */
public class SynchronizedTest1 {
    //锁住了本类的实例对象
    public synchronized void test1() {
        try {
            System.out.println(Thread.currentThread().getName() + " test1 进入了同步方法" + new Date());

            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " test1 休眠结束" + new Date());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void test2() {
        System.out.println("asdasd");
    }


    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest1 st = new SynchronizedTest1();
        SynchronizedTest1 st2 = new SynchronizedTest1();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " test 准备进入" + new Date());
            st.test1();
        }).start();
        Thread.sleep(1000);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " test 准备进入" + new Date());
            st.test2();
        }).start();

    }

}
