package com.whut.algorithm.high.frequence.offer.problem_offer_63_gu_piao_de_zui_da_li_run_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/10 21:39
 * @desription
 */
public class GuPiaoDeZuiDaLiRunLcof {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0)
            return 0;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                // 解释：
                //   dp[i][0]
                // = max(dp[-1][0], dp[-1][1] + prices[i])
                // = max(0, -infinity + prices[i]) = 0
                dp[i][1] = -prices[i];
                //解释：
                //   dp[i][1]
                // = max(dp[-1][1], dp[-1][0] - prices[i])
                // = max(-infinity, 0 - prices[i])
                // = -prices[i]
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {

    }
}
