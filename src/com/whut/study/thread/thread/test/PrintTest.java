package com.whut.study.thread.thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/16 16:18
 * @desription
 */
public class PrintTest {
    public static void main(String[] args) throws InterruptedException {
        AwaitSignal awaitSignal = new AwaitSignal(5);
        // 构建三个条件变量
        Condition a = awaitSignal.newCondition();
        Condition b = awaitSignal.newCondition();
        Condition c = awaitSignal.newCondition();
        // 开启三个线程
        Thread threadA = new Thread(() -> {
            awaitSignal.print("a", a, b);
        });

        threadA.setName("ThreadA");

        threadA.start();

        Thread threadB = new Thread(() -> {
            awaitSignal.print("b", b, c);
        });

        threadB.setName("threadB");
        threadB.start();


        Thread threadC = new Thread(() -> {
            awaitSignal.print("c", c, a);
        });

        threadC.setName("threadC");
        threadC.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        awaitSignal.lock();
        try {
            // 先唤醒a
            a.signal();
        } finally {
            awaitSignal.unlock();
        }
    }


}

class AwaitSignal extends ReentrantLock {

    // 循环次数
    private int loopNumber;

    public AwaitSignal(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    /**
     * @param print   输出的字符
     * @param current 当前条件变量
     * @param next    下一个条件变量
     */
    public void print(String print, Condition current, Condition next) {

        for (int i = 0; i < loopNumber; i++) {
            lock();
            // 获取锁之后等待
            try {
                current.await();
                System.out.print(print);
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                unlock();
            }

            if(Thread.currentThread().getName().equals("threadC")){
                System.out.println();
            }


        }
    }

}
