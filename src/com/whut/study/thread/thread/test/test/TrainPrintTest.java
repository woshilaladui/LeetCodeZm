package com.whut.study.thread.thread.test.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/19 16:11
 * @desription
 */
public class TrainPrintTest {
    public static void main(String[] args) {
        AwaitSignalE awaitSignalE = new AwaitSignalE(5);
        Condition a = awaitSignalE.newCondition();
        Condition b = awaitSignalE.newCondition();
        Condition c = awaitSignalE.newCondition();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,
                6,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        Thread threadA = new Thread(() -> {
            awaitSignalE.print("a",a,b);
        });
        threadA.setName("threadA");

        Thread threadB = new Thread(() -> {
            awaitSignalE.print("b",b,c);
        });
        threadB.setName("threadB");

        Thread threadC = new Thread(() -> {
            awaitSignalE.print("c",c,a);
        });
        threadC.setName("threadC");
        threadC.start();

        executor.execute(threadA);
        executor.execute(threadB);
        //executor.execute(threadC);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        awaitSignalE.lock();
        a.signal();
        awaitSignalE.unlock();

        executor.shutdown();

        while (!executor.isTerminated()){
        }



    }
}

class AwaitSignalE extends ReentrantLock{
    private int loopNum;

    public AwaitSignalE() {
    }

    public AwaitSignalE(int loopNum) {
        this.loopNum = loopNum;
    }

    public void print(String print, Condition current, Condition next){
        for (int i = 0; i < loopNum; i++) {
            lock();

            try {
                current.await();
                System.out.print(print);
                if(Thread.currentThread().getName().equals("threadC")){
                    System.out.println();
                }
              //  System.out.println(Thread.currentThread().getName());
                next.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                unlock();
            }


        }
    }
}



