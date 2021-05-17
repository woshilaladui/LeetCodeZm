package com.whut.algorithm.thread.thread_list;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/22 19:41
 * @desription
 */
public class PrintABC extends Thread{
    int count = 0; //打印次数
    Lock lock = new ReentrantLock();  //可重写锁
    Condition conditionA = this.lock.newCondition();
    Condition conditionB = this.lock.newCondition();
    Condition conditionC = this.lock.newCondition();

    public class PrintA implements Runnable {
        @Override
        public void run() {
            while (true)
                if (count < 15) {
                    lock.lock();
                    System.out.print("A");
                    try {
                        conditionB.signal();  //线程b唤醒,因为a打印完应该打印b
                        conditionA.await();  //线程a进入等待队列
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
        }
    }

    public class PrintB implements Runnable {
        @Override
        public void run() {
            while (true)
                if (count < 15) {
                    lock.lock();
                    System.out.print("B");
                    try {
                        conditionC.signal();
                        conditionB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
        }
    }

    public class PrintC implements Runnable {
        @Override
        public void run() {
            while (true)
                if (count < 15) {
                    lock.lock();
                    System.out.println("C" + count);
                    count++;//打印完c后,count++
                    try {
                        conditionA.signal();
                        conditionC.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
        }
    }

    public static void main(String[] args) {
        PrintABC printABCD = new PrintABC();
        Thread thread1 = new Thread(printABCD.new PrintA());
        Thread thread2 =new Thread(printABCD.new PrintB());
        Thread thread3 = new Thread(printABCD.new PrintC());

        thread1.start();
        thread2.start();
        thread3.start();


        while (Thread.activeCount() == 2){
            System.out.println("a");
            Thread.yield();

        }



        System.out.println(thread1.isAlive());
        System.out.println(thread2.isAlive());
        System.out.println(thread3.isAlive());
    }

}
