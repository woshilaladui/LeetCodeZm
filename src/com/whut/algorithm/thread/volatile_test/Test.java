package com.whut.algorithm.thread.volatile_test;

import com.whut.algorithm.circular_dependence.A;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/9 14:24
 * @desription
 */
public class Test {
    public static void main(String[] args) {
        Aabing a = new Aabing();

        a.start();

        for (;;){
            synchronized (a){
                if(a.isFlag()){
                    System.out.println("hhh");
                }
            }

        }
    }

    static class Aabing extends Thread{
        private boolean flag = false;

        public boolean isFlag() {
            return flag;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("flag = " + flag);
        }
    }
}
