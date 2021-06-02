package com.whut.algorithm.high.frequence.problem455_Candy;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/9 20:21
 * @desription
 */
public class Test {

    private static volatile boolean flag = true;



    public static void main(String[] args) {

        for (int i = 0; i <= 10; i++) {
            new Thread(() -> {
                SingletonTest.getInstance();
            },String.valueOf(i)).start();
        }
    }

}
