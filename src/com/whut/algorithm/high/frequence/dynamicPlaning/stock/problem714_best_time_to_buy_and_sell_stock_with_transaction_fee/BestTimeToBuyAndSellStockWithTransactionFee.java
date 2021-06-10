package com.whut.algorithm.high.frequence.dynamicPlaning.stock.problem714_best_time_to_buy_and_sell_stock_with_transaction_fee;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/2 16:28
 * @desription
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {



    /**
     * 二维数组解题
     * <p>
     * 相当于上个题目k变成了无限
     * <p>
     * <p>
     * 原始动态转移方程为
     * <p>
     * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+price[i])
     * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-price[i] - fee)
     * <p>
     * 由于k无限到 k=k-1 故上述转移方程中k这个维度可以丢弃
     * dp[i][0] = max(dp[i-1][0],dp[i-1][1]+price[i])
     * dp[i][1] = max(dp[i-1][1],dp[i-1][0]-price[i]-fee)
     * <p>
     * 初始化
     * dp[0][0] = max(dp[-1][0],dp[-1][1]+price[0]) = max(0,-infinity) = 0
     * dp[0][1] = max(dp[-1][1],dp[-1][0]-price[0]) = max(-infinity,-price[0]) = -price[0]
     *
     * @param prices
     * @return
     */
    private static int maxProfit_with_fee(int[] prices,int fee){

        if (prices.length == 0)
            return 0;

        int n = prices.length;

        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int temp;

        for(int i=0;i<n;i++){
            temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1,temp-prices[i]-fee);
        }

        return dp_i_0;
    }

    public static void main(String[] args) {

        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit_with_fee(prices,fee));

    }
}
