package com.whut.study.thread.thread_list;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/19 14:15
 * @desription
 *
 * 消费生产队列
 */
public class PCQ {
    public static void main(String[] args) {
        Queue queue = new Queue();
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }

    static class Producer implements Runnable {

        Queue queue;

        Producer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10000; i++) {
                    doingLongTime();
                    queue.putEle(new Random().nextInt()*10000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void doingLongTime() {
        }

    }

    static class Consumer implements Runnable {

        Queue queue;

        Consumer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10000; i++) {
                    doingLongTime();
                    queue.takeEle();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void doingLongTime() {

        }

    }

    static class Queue {
        Lock lock = new ReentrantLock();
        Condition prodCond  = lock.newCondition();
        Condition consCond = lock.newCondition();

        final int CAPACITY = 10;
        Object[] container = new Object[CAPACITY];
        int count = 0;
        int putIndex = 0;
        int takeIndex = 0;

        public void putEle(Object ele) throws InterruptedException {
            try {
                lock.lock();
                while (count == CAPACITY) {
                    System.out.println(String.format("队列已满：%d，生产者开始睡大觉。。。", count));

                    prodCond.await();
                }
                container[putIndex] = ele;
                System.out.println(String.format("生产元素：%d", ele));

                putIndex++;
                if (putIndex >= CAPACITY) {
                    putIndex = 0;
                }
                count++;
                System.out.println(String.format("通知消费者去消费。。。"));
                consCond.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public Object takeEle() throws InterruptedException {
            try {
                lock.lock();
                while (count == 0) {
                    System.out.println(String.format("队列已空：%d，消费者开始睡大觉。。。", count));
                    consCond.await();
                }
                Object ele = container[takeIndex];
                System.out.println(String.format("消费元素：%d", ele));

                takeIndex++;
                if (takeIndex >= CAPACITY) {
                    takeIndex = 0;
                }
                count--;
                System.out.println(String.format("通知生产者去生产。。。"));
                prodCond.signalAll();
                return ele;
            } finally {
                lock.unlock();
            }
        }
    }

}
