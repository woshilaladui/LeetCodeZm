package com.whut.algorithm.high.frequence.offer.problem_offer_58_2_zuo_xuan_zhuan_zi_fu_chuan_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/6 20:26
 * @desription
 */
public class ZuoXuanZhuanZiFuChuanLcof {

    public static String reverseLeftWords(String s, int n) {

        return s.substring(n) + s.substring(0,n);
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg",2));
    }
}
