package com.whut.study.thread.thread.test.test;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/19 16:41
 * @desription
 */
public class MyRunnable implements Runnable {

    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("a");
    }
}
