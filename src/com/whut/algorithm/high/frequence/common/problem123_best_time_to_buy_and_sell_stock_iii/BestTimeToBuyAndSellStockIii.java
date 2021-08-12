package com.whut.algorithm.high.frequence.common.problem123_best_time_to_buy_and_sell_stock_iii;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/12 15:15
 * @desription
 */
public class BestTimeToBuyAndSellStockIii {

    public int maxProfit(int[] prices) {

        /**
         * k = i2
         *
         * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
         * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i])
         *
         *
         * k 不可以忽略
         * 遍历所有k的情况
         *
         *
         */
        if (prices.length == 1)
            return 0;

        //k = 2
        int[][][] dp = new int[prices.length][3][2];
        /**
         * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
         * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i])
         *
         * dp[0][k][0] = max(dp[-1][k][0],dp[-1][k][1] + prices[0]) = 0;
         *
         * dp[0][k][1] = max(dp[-1][k][1],dp[-1][k-1][0] - prices[0]) = -prices[0]
         */
        for(int k = 1;k<=2;k++){
            dp[0][k][0] = 0;
            dp[0][k][1] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int k = 2; k >= 1; k--) {
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][2][0];
    }

    public static void main(String[] args) {

    }
}
