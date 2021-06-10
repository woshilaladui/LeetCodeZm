package com.whut.algorithm.high.frequence.dynamicPlaning.kmp;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/18 17:10
 * @desription
 */
public class TestKmp {

    private static KMP kmp = new KMP("aba");

    public static void main(String[] args) {


        System.out.println(kmp.search("aaabbbbbabaac"));

    }
}
