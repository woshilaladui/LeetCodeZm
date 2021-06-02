package com.whut.study.thread.thread;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/30 14:11
 * @desription
 */
public class Producer implements Runnable {

    private Product product;

    public Producer() {
    }

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            if (i % 2 == 0) {
                product.put("馒头", "白色");
            } else {
                product.put("玉米", "黄色");
            }
            i++;
        }
    }
}
