package com.whut.study.io.test;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/7 11:01
 * @desription
 */
public class TestMain extends Thread{
    static int count;

    @Override
    public  void run() {
//        for(int i = 0;i < 4;i++){
//            count++;
//            System.out.println(i);
//        }

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
//
//        TestMain tJavaThread = new TestMain();
//
//        tJavaThread.start();
//       // tJavaThread.join();
//        while (Thread.activeCount() > 2) {
//            Thread.yield();
//        }
//        System.out.println("count = " + count);

//        ExecutorService service = Executors.newSingleThreadExecutor();
//        for(int i = 0;i < 5;i++){
//            service.execute(new TestMain());
//        }
//        service.shutdown();

        TestMain join1 = new TestMain();
        TestMain join2 = new TestMain();
        TestMain join3 = new TestMain();

        join1.start();
        join1.setName("joina");
        join1.join();

        join2.start();
        join2.setName("joinb");
        join3.start();
        join3.setName("joinc");


    }
}
