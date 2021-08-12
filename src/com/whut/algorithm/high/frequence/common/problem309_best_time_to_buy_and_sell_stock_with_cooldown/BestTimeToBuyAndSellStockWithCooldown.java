package com.whut.algorithm.high.frequence.common.problem309_best_time_to_buy_and_sell_stock_with_cooldown;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/12 14:57
 * @desription
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {

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
         * dp[i][1] = max(dp[i-1][1],dp[i-2][0] - prices[i])
         *
         * dp[0][0] = max(dp[-1][0],dp[-1][1] + prices[i]) = 0
         * dp[0][1] = max(dp[-1][1],dp[-2][0] - prices[i]) = -prices[0]
         * dp[1][0] = max(dp[0][0],dp[0][1] + prices[1]) = price[1] - prices[0]
         * dp[1][1] = max(dp[0][1],dp[-1][0] - prices[1]) = max(-prices[0],-prices[1])
         */
        if (prices.length == 1)
            return 0;

        int [][]dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        dp[1][0] = Math.max(0,prices[1] - prices[0]);
        dp[1][1] = Math.max(-prices[0],-prices[1]);

        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            //是i-2 因为有一天冷静期
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0] - prices[i]);
        }

        return dp[prices.length-1][0];
    }

    public static void main(String[] args) {

    }
}
