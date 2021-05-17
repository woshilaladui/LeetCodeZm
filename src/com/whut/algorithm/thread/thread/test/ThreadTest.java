package com.whut.algorithm.thread.thread.test;

import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/18 20:54
 * @desription
 */
public class ThreadTest {


    public static class PTest {
        private static boolean flag = false;

        public synchronized void get() {
            if( flag == false) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("get766666666666");
            flag = false;
            notify();
        }

        public synchronized void put(){
            if( flag == true) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("put");
            flag = true;
            notify();
        }

    }

    public static class Thread1 implements Runnable {

        private PTest pTest;

        public Thread1(PTest pTest) {
            this.pTest = pTest;
        }

        @Override
        public synchronized void run() {

            while (true){
                pTest.get();
            }

        }
    }

    public static class Thread2 implements Runnable {

        public PTest pTest;

        public Thread2(PTest pTest) {
            this.pTest = pTest;
        }

        @Override
        public synchronized void run() {

            while (true){
                pTest.put();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        PTest p = new PTest();
        Thread thread1 = new Thread(new Thread1(p));
        Thread thread2 = new Thread(new Thread2(p));

        thread1.start();
        thread2.start();

    }

}
