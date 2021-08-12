package com.whut.algorithm.high.frequence.offer.problem_offer_14_1_jian_sheng_zi_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/28 15:00
 * @desription
 */
public class JianShengZiLcof {

    /**
     * 1. 我们想要求长度为n的绳子剪掉后的最大乘积，可以从前面比n小的绳子转移而来
     * 2. 用一个dp数组记录从0到n长度的绳子剪掉后的最大乘积，也就是dp[i]表示长度为i的绳子剪成m段后的最大乘积，初始化dp[2] = 1
     * 3. 我们先把绳子剪掉第一段（长度为j），如果只剪掉长度为1，对最后的乘积无任何增益，所以从长度为2开始剪
     * 4. 剪了第一段后，剩下(i - j)长度可以剪也可以不剪。如果不剪的话长度乘积即为j * (i - j)；如果剪的话长度乘积即为j * dp[i - j]。取两者最大值max(j * (i - j), j * dp[i - j])
     * 5. 第一段长度j可以取的区间为[2,i)，对所有j不同的情况取最大值，因此最终dp[i]的转移方程为
     * dp[i] = max(dp[i], max(j * (i - j), j * dp[i - j]))
     * 最后返回dp[n]即可
     *
     * @param n
     * @return
     */
    public static int cuttingRope_leetcode(int n) {

        //dp[i] 表示i长度的绳子最大乘积
        int[] dp = new int[n + 1];

        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            //第一段绳子减法
            for (int j = 2; j < i; j++) {
                /**
                 *
                 * dp[i]
                 *
                 * j*(i-j) i-j不选择剪
                 *
                 * i-j选择剪 dp[i-j]
                 *
                 */
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }

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

        return (int) (Math.pow(2, sumOf2) * Math.pow(3, sumOf3));
    }

    public static void main(String[] args) {
        //953271190
        //995115582
        // System.out.println(1000000008 % 1000000007);
        System.out.println(cuttingRope2(120));
    }
}
