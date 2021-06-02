package com.whut.algorithm.high.frequence.problem455_Candy;

import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/9 14:46
 * @desription
 */
public class Candy {
    /**
     * 贪心思想
     *
     * 尽量满足需求小的孩子
     *
     * 定义child指针指向孩子
     * 定义cookie指针指向糖果
     *
     * g[child]<=s[cookie]时说明糖果可以满足当前孩子则指针同时后移
     *
     *否则糖果指针后移
     *
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;

        while (child < g.length && cookie < s.length) {

//            if(g[child]<=s[cookie]){
//                child++;
//                cookie++;
//            }else {
//                cookie++;
//            }
            if (g[child] <= s[cookie])
                child++;
            cookie++;

        }


        return child;

    }

    public static void main(String[] args) {

        int[] g = new int[]{5, 10, 2, 9, 15, 9};
        int[] s = new int[]{6, 1, 20, 3, 8};

        System.out.println(findContentChildren(g,s));


    }

}
