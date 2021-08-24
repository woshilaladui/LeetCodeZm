package com.whut.algorithm.high.frequence.offer.problem_offer_16_shu_zhi_de_zheng_shu_ci_fang_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/18 15:54
 * @desription
 */
public class TrainShuZhiDeZhengShuCiFangLcof {


    public double myPow(double x, int n) {
        long N = n;
        if (N == 0)
            return 1;
        return n > 0 ? quickPow(x, N) : 1.0 / quickPow(x, -N);
    }

    private double quickPow(double x, long n) {
        double result = 1.0;
        double contribute = x;

        while (n > 0) {
            if ((n & 1) == 1) {
                result *= contribute;
            }

            contribute *= contribute;
            n = n >> 1;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
