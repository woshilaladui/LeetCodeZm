package com.whut.algorithm.high.frequence.offer.problem_offer_15_er_jin_zhi_zhong_1de_ge_shu_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/29 16:04
 * @desription
 */
public class ErJinZhiZhong1deGeShuLcof {

    /**
     * 从低位开始比较
     * 1    2      4      8
     * 1 -> 10 -> 100 -> 1000
     * <p>
     * eg: 100101101
     * <p>
     * <p>
     * <p>
     * 100101101
     * 000000001 -> != 0  count++
     * <p>
     * 100101101
     * 000000010  -> = 0
     * <p>
     * 100101101
     * 000000100  -> != 0 count++
     *
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0)
                result++;

        }

        return result;
    }

    public int hammingWeight2(int n) {
        int count = 0;

        while (n != 0) {
            n = n &( n-1);
            count++;
        }

        return count;
    }

    public boolean reorderedPowerOf2(int n) {
        return (n & (n-1) )== 0;
    }
    public static void main(String[] args) {

    }
}
