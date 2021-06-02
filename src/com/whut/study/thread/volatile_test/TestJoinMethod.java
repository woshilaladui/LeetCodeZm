package com.whut.study.thread.volatile_test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/16 11:14
 * @desription
 */
public class TestJoinMethod extends Thread{

    @Override
    public void run() {
        for(int i = 0;i < 5;i++){
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted sleep");
            }
            System.out.println(Thread.currentThread() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoinMethod join1 = new TestJoinMethod();
        TestJoinMethod join2 = new TestJoinMethod();
        TestJoinMethod join3 = new TestJoinMethod();

        join1.start();
        join1.join();

        join2.start();
        join3.start();

        Lock reentrantLock = new ReentrantLock();

        reentrantLock.lock();

        Condition condition = reentrantLock.newCondition();
        condition.notify();
        condition.signal();

    }
}