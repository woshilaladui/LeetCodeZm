package com.whut.algorithm.high.frequence.offer.problem_offer_56_1_shu_zu_zhong_shu_zi_chu_xian_de_ci_shu_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/5 21:00
 * @desription
 */
public class ShuZuZhongShuZiChuXianDeCiShuLcof {

    public int[] singleNumbers(int[] nums) {

        int ret = 0;

        for (int num : nums) {
            ret ^= num;
        }

        //ret = a ^ b
        //将a b 分到两个不同组中, 在异或结果中找到任意为 1 的位。
        // 1 代表两个二进制位置不同
        int div = 1;
        while ((div & ret) == 0)
            div <<= 1;

        int a = 0, b = 0;
        //分组

        for (int num : nums) {
            if ((div & num) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {

    }
}
