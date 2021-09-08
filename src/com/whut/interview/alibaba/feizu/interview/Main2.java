package com.whut.interview.alibaba.feizu.interview;

import java.util.concurrent.CyclicBarrier;


public class Main2 {

    static final int COUNT = 10;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < COUNT; i++) {
            new Thread(new Worker(i, cb)).start();
        }
    }


    private static CyclicBarrier cb = new CyclicBarrier(COUNT, ()->{
        System.out.println("--------");
    });



    static class Worker implements Runnable {


        CyclicBarrier cb;
        int num;


        Worker(int num, CyclicBarrier cb) {
            this.num = num;
            this.cb = cb;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(String.format("work" + i, num));
                try {
                    cb.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        private void doingLongTime() {
        }

    }

}
