package com.whut.algorithm.high.frequence.offer.problem_offer_65_bu_yong_jia_jian_cheng_chu_zuo_jia_fa_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/20 21:51
 * @desription
 */
public class BuYongJiaJianChengChuZuoJiaFaLcof {

    public int add(int a, int b) {

        // a + b = 进位 + 不考虑进位的结果
        // (a & b) << 1 为进位结果
        // a ^ b 为不考虑进位的结果
        //进位 + 不考虑进位的结果可能还会产生进位，所以在循环里
        while ((a & b) != 0) {
            //a 存放进位结果
            int temp = a;
            a = (a & b) << 1;

            // b 存放不考虑进位的结果
            b ^= temp;
        }
        return a ^ b;
    }

    public static void main(String[] args) {

    }
}
