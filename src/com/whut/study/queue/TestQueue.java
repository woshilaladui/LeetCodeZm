package com.whut.study.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/31 15:42
 * @desription
 */
public class TestQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        try {
            blockingQueue.put("a");
            System.out.println(blockingQueue.take());
            blockingQueue.put("b");
            blockingQueue.put("c");
            blockingQueue.put("d");

            System.out.println("----------------------");

            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
//            blockingQueue.take();
//            blockingQueue.take();
//            blockingQueue.take();
          //  blockingQueue.take();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
