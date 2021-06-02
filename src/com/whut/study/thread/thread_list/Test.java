package com.whut.study.thread.thread_list;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/19 13:50
 * @desription
 */
public class Test {
    static Phaser ph = new Phaser() {

        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            return super.onAdvance(phase, registeredParties);
        }
    };

    public static void main(String[] args) {

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock1.lock();
                try {
                    System.out.println("lock1");
                    TimeUnit.SECONDS.sleep(3);
                    lock2.lock();
                    System.out.println("lock2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock1.unlock();
                    lock2.unlock();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock2.lock();
                System.out.println("thread2 lock2");
                try {
                    TimeUnit.SECONDS.sleep(2);
                    lock1.lock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock1.unlock();
                    lock2.unlock();
                }
            }
        });

        thread1.setPriority(10);
        thread2.setPriority(1);

        thread1.start();
        thread2.start();

    }
}
