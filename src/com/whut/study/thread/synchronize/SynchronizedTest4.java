package com.whut.study.thread.synchronize;

import java.util.Date;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/18 19:57
 * @desription
 */
public class SynchronizedTest4 {


    //全局锁，类是全局唯一的
    public void test4() {
        synchronized (SynchronizedTest4.class) {
            try {
                System.out.println(Thread.currentThread().getName() + " test4 进入了同步块" + new Date());

                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " test4 休眠结束" + new Date());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedTest4 st = new SynchronizedTest4();
        SynchronizedTest4 st2 = new SynchronizedTest4();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " test 准备进入" + new Date());

            st.test4();
        }).start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " test 准备进入" + new Date());

            st2.test4();
        }).start();
    }

}
