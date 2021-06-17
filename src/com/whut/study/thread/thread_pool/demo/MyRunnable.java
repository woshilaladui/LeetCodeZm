package com.whut.study.thread.thread_pool.demo;

import java.util.Date;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/16 20:23
 * @desription
 */
public class MyRunnable implements Runnable {
    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" -" + command +"  -"+ " Start. Time = " + new Date());
        processCommand();
        //System.out.println(Thread.currentThread().getName() +" -" + command +"  -"+ " End. Time = " + new Date());
    }

    private void processCommand() {
        try {

            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
