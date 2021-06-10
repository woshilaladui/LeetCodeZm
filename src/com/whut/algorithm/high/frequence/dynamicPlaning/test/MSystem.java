package com.whut.algorithm.high.frequence.dynamicPlaning.test;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/14 15:40
 * @desription
 */
public class MSystem {

    private static boolean flag = false;

    public void println(String mag){

        println(flag,mag);

    }


    public void println(boolean flag, String msg) {
        if (flag) {
            System.out.println(msg);
        }
    }


    public static void main(String[] args) {
        System.out.println();
    }

}
