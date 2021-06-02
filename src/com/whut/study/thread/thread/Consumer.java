package com.whut.study.thread.thread;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/30 14:13
 * @desription
 */
public class Consumer implements Runnable {

    private Product product;

    public Consumer() {
    }

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true){
            product.get();
        }
    }
}
