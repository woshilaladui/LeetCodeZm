package com.whut.algorithm.twoSum;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/9 19:39
 * @desription
 */
public class Main {
    public static int a = 10;

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10000; i++) {
                    a++;
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10000; i++) {
                    a++;
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10000; i++) {
                    a++;
                }
            }
        }).start();

        Thread.sleep(10000);
        System.out.println(a);

    }
}
