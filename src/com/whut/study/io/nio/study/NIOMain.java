package com.whut.study.io.nio.study;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/15 16:30
 * @desription
 */
public class NIOMain {
    public static void main(String[] args) throws InterruptedException {

        new Thread(new NIOServerThread("server","client")).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new NIOClientThread("client","server")).start();

        TimeUnit.SECONDS.sleep(3);
        new Thread(new NIOClientThread("client2","server2","127.0.0.1")).start();
    }
}
