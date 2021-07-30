package com.whut.algorithm.high.frequence.offer.problem_offer_44_shu_zi_xu_lie_zhong_mou_yi_wei_de_shu_zi_lcof;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/27 20:38
 * @desription
 */
public class ShuZiXuLieZhongMouYiWeiDeShuZiLcof {

    public int findNthDigit(int n) {

        //所求数字的位数
        int digit = 1;
        //注意越界
        long start = 1;
        long count = 9;

        /**
         * 确定 n 所在 数字 的 位数 ，记为 digit ；
         * 确定 n 所在的 数字 ，记为 num ；
         * 确定 n 是 num 中的哪一数位，并返回结果。
         */
        while (n > count) {
            //确定 数字的位数和start
            n -= count;
            digit++;
            start *= 10;

            count = start * digit * 9;
        }

        long num = start + (n - 1) / digit; // 2.

        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

    public static void main(String[] args) {
        String []str = new String[10];

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

    }
}
