package com.whut.study.thread.thread_pool;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/16 19:28
 * @desription
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                6,
                10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(3),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < 10; i++) {
            int finalI = i;

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "is executing" + finalI);
                    try {
                        Thread.sleep(7000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.setName(i+"dfsfds");


            threadPoolExecutor.execute(thread);



        }
//
//    public static void main(String[] args) {
//
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(
//                4,
//                10,
//                2,
//                TimeUnit.MINUTES,
//                new LinkedBlockingQueue<>(20),
//                new ThreadPoolExecutor.DiscardPolicy());
//
//        System.out.println("---- before commit");
//        System.out.println("activeCount:" + executor.getActiveCount());
//        System.out.println("queueSize:" + executor.getQueue().size());
//
//        System.out.println("---- commit ... ");
//        int i =0;
//
//        for ( i = 0; i < 60; i++) {
//            System.out.println();
//            System.out.println("activeCount:" + executor.getActiveCount());
//            System.out.println("queueSize:" + executor.getQueue().size());
//
//
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    int random = new Random().nextInt(5);
//                    int time = 500 * random;
//                    try {
//                        Thread.sleep(time);
//                    } catch (Exception e) {
//
//                    }
//                }
//            });
//
//            thread.setName(i+"");
//
//            executor.execute(
//                    thread
//            );
//            System.out.println("i = " + thread.getName());
//        }
//
//        System.out.println("----- committed");
//        while (executor.getActiveCount() > 0) {
//            System.out.println();
//            System.out.println("activeCount:" + executor.getActiveCount());
//            System.out.println("queueSize:" + executor.getQueue().size());
//            try {
//                Thread.sleep(800);
//            } catch (Exception e) {
//
//            }
//        }
//        System.out.println("---- activeCount is 0 ");
//        System.out.println("activeCount:" + executor.getActiveCount());
//        System.out.println("queueSize:" + executor.getQueue().size());
//
//        executor.shutdown();
//    }
    }
}
