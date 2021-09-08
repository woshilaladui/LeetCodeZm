package com.whut.study.thread.thread.conditionConsumerAndProducer;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/1 10:49
 * @desription
 */
public class TrainConsumerAndProducer {
    private static int queueSize = 10;
    private static Lock lock = new ReentrantLock();
    private static Queue<Integer> queue = new ArrayBlockingQueue<>(10);
    private static Condition notFull = lock.newCondition();
    private static Condition notEmpty = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Consumer consumer = new Consumer();
        Producer producer = new Producer();
        consumer.start();
        producer.start();

        TimeUnit.SECONDS.sleep(1);
        consumer.interrupt();
        producer.interrupt();
    }

    static class Consumer extends Thread{
        @Override
        public void run() {
           consumer();
        }

        private void consumer(){
            boolean flag = true;

            while (flag){
                lock.lock();
                try {
                    while (queue.size() == 0){
                        try {
                            System.out.println("队列空，等待数据");
                            notEmpty.await();
                        }  catch (InterruptedException e){
                            flag = false;
                        }

                    }

                    notFull.signal();
                    queue.poll();
                    System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Producer extends Thread{
        @Override
        public void run() {
            produce();
        }

        private void produce(){
            boolean flag = true;

            while (flag){
                lock.lock();
                try {
                    while (queueSize == queue.size()){
                        try {
                            System.out.println("队列满，等待有空余空间");
                            notFull.await();
                        } catch (InterruptedException e) {
                            flag = false;
                        }
                    }

                    queue.offer(1);        //每次插入一个元素
                    notEmpty.signal();
                    System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
                }finally {
                    lock.unlock();
                }
            }
        }//end produce
    }
}
