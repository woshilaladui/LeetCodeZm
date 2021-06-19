package com.whut.study.thread.synchronize;

import java.util.Date;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/18 19:24
 * @desription
 */

/**
 * 同步代码块传参变量对象
 *
 * 同一个属性对象才会实现同步
 */
public class SynchronizedTest3 {

    public Integer lockObject;

    public SynchronizedTest3(Integer lockObject) {
        this.lockObject = lockObject;
    }

    //锁住了实例中的成员变量
    public void test3() {
        synchronized (lockObject) {
            try {
                System.out.println(Thread.currentThread().getName() + " test3 进入了同步块" + new Date());

                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " test3 休眠结束" + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        SynchronizedTest3 st = new SynchronizedTest3(128);
        SynchronizedTest3 st2 = new SynchronizedTest3(128);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " test 准备进入" + new Date());
            st.test3();
        }).start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " test 准备进入" + new Date());
            st2.test3();
        }).start();

    }
}
