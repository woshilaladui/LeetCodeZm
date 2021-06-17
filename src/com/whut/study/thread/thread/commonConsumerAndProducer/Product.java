package com.whut.study.thread.thread.commonConsumerAndProducer;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/30 14:05
 * @desription
 */
public class Product {
    private String name;
    private String color;

    //是否已经生产了
    private boolean isProduced = false;

    public synchronized void get() {
        if (isProduced == false) {
            try {
                //仓库没有东西了，需要生产
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者消费: " + name + " " + color);
        isProduced = false;
        notify();

    }

    public synchronized void put(String name,String color){
        if(isProduced){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        this.name = name;this.color = color;
        System.out.println("生产者生产："+this.name+" "+this.color);
        isProduced = true;
        notify();
    }

}
