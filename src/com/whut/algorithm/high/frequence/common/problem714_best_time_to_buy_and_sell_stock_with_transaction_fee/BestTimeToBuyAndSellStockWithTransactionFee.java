package com.whut.algorithm.high.frequence.common.problem714_best_time_to_buy_and_sell_stock_with_transaction_fee;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/12 15:10
 * @desription
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {

        /**
         * k = infinity = k -1
         *
         * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
         * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i] - fee)
         *
         * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
         * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k][0] - prices[i] - fee)
         *
         * k可以忽略
         *
         * dp[i][0] = max(dp[i-1][0],dp[i-1][1] + prices[i])
         * dp[i][1] = max(dp[i-1][1],dp[i-1][0] - prices[i] - fee)
         *
         * dp[0][0] = max(dp[-1][0],dp[-1][1] + prices[i]) = 0
         * dp[0][1] = max(dp[-1][1],dp[-1][0] - prices[i] - fee) = -prices[0] - fee
         *
         */
        if (prices.length == 1)
            return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }

        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {

    }
}
