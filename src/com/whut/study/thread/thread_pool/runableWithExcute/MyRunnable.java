package com.whut.study.thread.thread_pool.runableWithExcute;

import com.whut.study.thread.thread_pool.RunResult;

import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/17 19:40
 * @desription
 */
public class MyRunnable implements Runnable {
    // 运算结果类
    private RunResult result;
    // 线程同步器
    private CountDownLatch main;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " 线程开始执行" + "-" + result.getParam());
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j <= 200000000; j++) {
                if (j == 200000000 && null != result.getParam()) {
                    result.setResult(result.getParam() * 10);
                    result.setSuccess(true);
                    System.out.println(name + " 线程正在进行计算" + "-" + result.getParam());
                } else {
                    result.setSuccess(false);
                }
            }
        }
        System.out.println(name + " 线程执行完毕" + "-" + result.getParam());
        main.countDown();
    }

    public MyRunnable(RunResult result, CountDownLatch main) {
        super();
        this.result = result;
        this.main = main;
    }

    public MyRunnable() {
        super();
    }

}
