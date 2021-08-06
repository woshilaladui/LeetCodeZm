package com.whut.algorithm.high.frequence.offer.problem_offer_56_2_shu_zu_zhong_shu_zi_chu_xian_de_ci_shu_ii_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/5 21:23
 * @desription
 */
public class ShuZuZhongShuZiChuXianDeCiShuIiLcof {

    public int singleNumber(int[] nums) {
        //统计二进制位出现的次数
        int[] count = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                count[j] += num & 1;
                num >>>= 1;
            }
        }
        //注意高低位

        int result = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            //反向还原
            result |= count[31 - i] % m;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
