package com.whut.study.thread.test;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/16 15:18
 * @desription
 */
public class TSynchronized implements Runnable{


    volatile static int i = 0;

    public void increase(){
        i++;
    }


    @Override
    public void run() {
        for(int i = 0;i < 1000;i++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        TSynchronized tSynchronized = new TSynchronized();
        Thread aThread = new Thread(tSynchronized);
        Thread bThread = new Thread(tSynchronized);

        aThread.start();
        aThread.interrupt();
        bThread.start();
        aThread.join();
        bThread.join();
        System.out.println("i = " + i);
    }
}