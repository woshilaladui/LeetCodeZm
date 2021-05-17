package com.whut.algorithm.thread.thread_pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/16 10:46
 * @desription
 */
public class CallableTask implements Callable {

    private static int count;

    public CallableTask(int count) {
        this.count = count;
    }

    @Override
    public Integer call() throws Exception {

        TimeUnit.SECONDS.sleep(5);
        count++;

        return count;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableTask callableTask = new CallableTask(10);

        FutureTask<Integer> task = new FutureTask<Integer>(callableTask);

        Thread thread = new Thread(task);
        thread.start();

        Integer result = task.get();

        System.out.println(result);

    }
}
