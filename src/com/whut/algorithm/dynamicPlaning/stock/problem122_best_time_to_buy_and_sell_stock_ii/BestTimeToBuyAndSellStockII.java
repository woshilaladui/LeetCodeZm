package com.whut.algorithm.dynamicPlaning.stock.problem122_best_time_to_buy_and_sell_stock_ii;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/2 15:57
 * @desription
 */
public class BestTimeToBuyAndSellStockII {


    /**
     * 二维数组解题
     * <p>
     * 相当于上个题目k变成了无限
     * <p>
     * <p>
     * 原始动态转移方程为
     * <p>
     * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+price[i])
     * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-price[i])
     * <p>
     * 由于k无限到 k=k-1 故上述转移方程中k这个维度可以丢弃
     * dp[i][0] = max(dp[i-1][0],dp[i-1][1]+price[i])
     * dp[i][1] = max(dp[i-1][1],dp[i-1][0]-price[i])
     * <p>
     * 初始化
     * dp[0][0] = max(dp[-1][0],dp[-1][1]+price[0]) = max(0,-infinity) = 0
     * dp[0][1] = max(dp[-1][1],dp[-1][0]-price[0]) = max(-infinity,-price[0]) = -price[0]
     *
     * @param prices
     * @return
     */
    public static int maxProfit_k_inf_v1(int[] prices) {

        if (prices.length == 0)
            return 0;

        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {

            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

        }

        return dp[n - 1][0];
    }

    /**
     * 根据上面可以推出只和前面一天有关联，故可以用递推来解决
     *
     * @param prices
     * @return
     */
    public static int maxProfit_k_inf_v2(int[] prices) {

        if (prices.length == 0)
            return 0;

        int n = prices.length;

        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int temp;

        for (int i = 0; i < n; i++) {

            /**
             *
             * 观察可得 dp[i-1][0] 转移给左边的 dp[i][0] ->dp_i_0
             * 而下面要用到 dp[i-1][0] (dp_i_0)的值已经被污染了，所以需要临时保存起来
             *
             */
            temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1,temp-prices[i]);

        }


        return dp_i_0;
    }

    public static void main(String[] args) {

        int[] price = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit_k_inf_v2(price));


    }
}
