package com.whut.algorithm.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/29 18:57
 * @desription
 */
public class TestThread {

    private static ReentrantLock lock = new ReentrantLock(true);

    static class Thread1 extends Thread {

        @Override
        public void run() {

            lock.lock();
            for (int i = 0; i < 3; i++)
                System.out.println("Thread1 run" + i);

            lock.unlock();
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            lock.lock();
            for (int i = 0; i < 3; i++)
                System.out.println("Thread2 run" + i);
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        Thread1 t1 = new Thread1();
        //lock.lock();
        t1.setName("t1");
        //lock.unlock();

        Thread2 t2 = new Thread2();
        t2.setName("t2");




        t1.start();


        t2.start();


    }
}
