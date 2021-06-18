package com.whut.study.thread.thread_pool.callableWithSubmit;

import com.whut.study.thread.thread_pool.RunResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/17 19:51
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(6, 10, 10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(20),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        // 存放Future<>的集合
        List<Future<RunResult>> list = new ArrayList<Future<RunResult>>(12);
        // 线程同步器
        CountDownLatch main = new CountDownLatch(12);
        for (int i = 1; i <= 12; i++) {
            RunResult result = new RunResult();
            result.setParam(i);
            MyCallable callable = new MyCallable(result,main);
            Future<RunResult> runResultFuture = threadPool.submit(callable);
            list.add(runResultFuture);
        }
        try {
            main.await();
            for (int i = 0; i < list.size(); i++) {
                RunResult runResult = list.get(i).get();
                System.out.println(runResult.toString());
            }
            // 线程池不用了，关闭线程池
            threadPool.shutdown();
            //threadPool.shutdownNow();
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {

        }
    }
}
