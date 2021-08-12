package com.whut.algorithm.high.frequence.common.problem122_best_time_to_buy_and_sell_stock_ii;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/12 14:47
 * @desription
 */
public class BestTimeToBuyAndSellStockIi {

    public static int maxProfit(int[] prices) {

        /**
         * k = infinity = k -1
         *
         * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
         * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i])
         *
         * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
         * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k][0] - prices[i])
         *
         * k可以忽略
         *
         * dp[i][0] = max(dp[i-1][0],dp[i-1][1] + prices[i])
         * dp[i][1] = max(dp[i-1][1],dp[i-1][0] - prices[i])
         *
         * dp[0][0] = max(dp[-1][0],dp[-1][1] + prices[i]) = 0
         * dp[0][1] = max(dp[-1][1],dp[-1][0] - prices[i]) = -prices[0]
         *
         */
        if (prices.length == 1)
            return 0;

        int [][]dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }

        return dp[prices.length-1][0];
    }

    public static void main(String[] args) {
        int[]nums = new int[]{2,1};
        int i = maxProfit(nums);
        System.out.println(i);

    }
}
