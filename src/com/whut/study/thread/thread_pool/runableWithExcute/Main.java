package com.whut.study.thread.thread_pool.runableWithExcute;

import com.whut.study.thread.thread_pool.RunResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/17 19:45
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(6, 10, 10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(20),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        // 存放结果类的集合
        List<RunResult> list = new ArrayList<RunResult>(12);
        // 线程同步器
        CountDownLatch main = new CountDownLatch(12);
        for (int i = 1; i <= 12; i++) {
            RunResult result = new RunResult();
            result.setParam(i);
            list.add(result);
            MyRunnable runnable = new MyRunnable(result,main);
            threadPool.execute(runnable);
        }
        try {
            main.await();
            for (RunResult runResult : list) {
                System.out.println(runResult.toString());
            }
            // 线程池不用了，关闭线程池
            threadPool.shutdown();
            //threadPool.shutdownNow();
        } catch (InterruptedException e) {

        }
    }
}
