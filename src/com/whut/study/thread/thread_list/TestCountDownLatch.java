package com.whut.study.thread.thread_list;

import java.util.concurrent.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/31 15:47
 * @desription
 */
public class TestCountDownLatch {

    private volatile int a = 0;
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            10,
            10,
            10L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        for (int i = 0; i < 10; i++) {
            CountDownLatch countDownLatch = new CountDownLatch(10);
            for (int j = 0; j < 10; j++) {
                Workers workers = new Workers("name " + j, countDownLatch);
                Future<String> future = executor.submit(workers);
                System.out.println(future.get());
            }
            countDownLatch.await();
            System.out.println("--------------");
        }
        while (!executor.isTerminated())
            executor.shutdown();
    }

    private static class Workers implements Callable<String>{

        private String name;

        private CountDownLatch countDownLatch;

        public Workers() {
        }

        public Workers(String name, CountDownLatch countDownLatch) {
            this.name = name;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public String call() throws Exception {

            System.out.println(name);
            countDownLatch.countDown();

            return "ok" + name;
        }
    }
}
