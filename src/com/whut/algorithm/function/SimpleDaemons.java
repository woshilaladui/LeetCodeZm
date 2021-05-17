package com.whut.algorithm.function;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/18 20:25
 * @desription
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                System.out.println("sleep() interrupted");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0;i < 10;i++){
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All Daemons started");
        TimeUnit.MILLISECONDS.sleep(175);

        ExecutorService service = Executors.newCachedThreadPool();
    }
}
