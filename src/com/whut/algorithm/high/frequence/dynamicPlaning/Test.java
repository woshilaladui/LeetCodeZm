package com.whut.algorithm.high.frequence.dynamicPlaning;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/22 16:24
 * @desription
 */
public class Test {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    lock.lock();
                    System.out.println("A");
                    conditionB.signal();
                    try {
                        conditionA.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    lock.lock();
                    System.out.println("B");
                    conditionC.signal();
                    try {
                        conditionB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0;i< 5;i++){
                    lock.lock();
                    System.out.println("C");
                    conditionA.signal();
                    try {
                        conditionC.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                        System.out.println("unlock C");
                    }
                }
            }
        });

        threadPoolExecutor.execute(threadA);
        threadPoolExecutor.execute(threadB);
        threadPoolExecutor.execute(threadC);




        threadPoolExecutor.shutdown();
    }


}
