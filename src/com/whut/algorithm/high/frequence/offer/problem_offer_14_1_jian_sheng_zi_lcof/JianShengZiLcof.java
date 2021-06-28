package com.whut.algorithm.high.frequence.offer.problem_offer_14_1_jian_sheng_zi_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/28 15:00
 * @desription
 */
public class JianShengZiLcof {
    public static int cuttingRope(int n) {

        /**
         *
         * f(n) = max(f(i) * f(n-i))
         *
         * 所以 f(i)也可以运用上述公式
         *
         *
         */
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        int[] dp = new int[n + 1];
        //只有长度为 2 和 3 的绳子不应再切分，
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        //i 为绳子总长度
        for (int i = 4; i <= n; i++) {
            int max = 0;

            for (int j = 1; j <= i / 2; j++) {
                int product = dp[j] * dp[i - j];
                if (max < product)
                    max = product;
            }

            dp[i] = max;
        }

        return dp[n];
    }

    //贪心
    public static int cuttingRope2(int n) {

        if (n == 2)
            return 1;
        if (n == 3)
            return 2;


        //尽可能的分解为3 和 4(2 * 2)  并且 2 * 2 > 3 * 1
        int sumOf3 = n / 3;

        // 2 * 2 > 3 * 1
        if (n - sumOf3 * 3 == 1)
            sumOf3 -= 1;

        int sumOf2 = (n - sumOf3 * 3) / 2;

        return (int) (Math.pow(2,sumOf2) * Math.pow(3,sumOf3));
    }

    public static void main(String[] args) {
        //953271190
        //995115582
        // System.out.println(1000000008 % 1000000007);
        System.out.println(cuttingRope2(120));
    }
}
