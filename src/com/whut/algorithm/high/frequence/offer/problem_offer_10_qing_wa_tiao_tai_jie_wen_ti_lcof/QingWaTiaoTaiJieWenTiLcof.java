package com.whut.algorithm.high.frequence.offer.problem_offer_10_qing_wa_tiao_tai_jie_wen_ti_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/19 19:26
 * @desription
 */
public class QingWaTiaoTaiJieWenTiLcof {

    public static int numWays(int n) {

        if (n == 0)
            return 1;

        if (n == 1)
            return 1;

        if (n == 2)
            return 2;

        int mod = 1000000007;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] % mod + dp[i - 2] % mod;
        }

        return dp[n] % mod;
    }

    public static void main(String[] args) {
        System.out.println(numWays(46));
    }
}
