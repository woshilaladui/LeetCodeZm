package com.whut.study.thread.thread_list;

import java.util.concurrent.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/1 10:10
 * @desription
 */
public class TestCyclicBarrier {
    private static volatile int a = 0;
    private static CountDownLatch countDownLatch;
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            10,
            10,
            10L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),
            new ThreadPoolExecutor.DiscardPolicy()
    );

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
            countDownLatch.countDown();
            System.out.println("-------------");
        });



        for (int i = 0; i < 10; i++) {
            countDownLatch = new CountDownLatch(1);
            for (int j = 0; j < 10; j++) {
                executor.execute(new WorkerCy(j + "", cyclicBarrier));
            }

            countDownLatch.await();
        }

        executor.shutdown();
    }

    private static class WorkerCy implements Runnable {
        private String name;
        private CyclicBarrier cyclicBarrier;

        public WorkerCy() {
        }

        public WorkerCy(String name, CyclicBarrier cyclicBarrier) {
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            synchronized (WorkerCy.class){
                System.out.println("name  =  " + a++);
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
