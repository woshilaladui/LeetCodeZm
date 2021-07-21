package com.whut.study.thread.thread.commonConsumerAndProducer;

import com.whut.study.thread.thread.commonConsumerAndProducer.Consumer;
import com.whut.study.thread.thread.commonConsumerAndProducer.Producer;
import com.whut.study.thread.thread.commonConsumerAndProducer.Product;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/30 14:14
 * @desription
 */
public class Test {
    public static void main(String[] args) {
        Product product = new Product();

        Consumer consumer = new Consumer(product);

        Thread t1 = new Thread(consumer);

        Producer producer = new Producer(product);
        Thread t2 = new Thread(producer);

        t1.start();
        t2.start();
    }
}
