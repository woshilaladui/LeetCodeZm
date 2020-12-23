package com.whut.algorithm.dynamicPlaning.stock.problem188_best_time_to_buy_and_sell_stock_iv;

import com.whut.algorithm.dynamicPlaning.stock.problem122_best_time_to_buy_and_sell_stock_ii.BestTimeToBuyAndSellStockII;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/2 17:14
 * @desription
 */
public class BestTimeToBuyAndSellStockIV {


    /**
     * 有了上一题 k = 2 的铺垫，这题应该和上一题的第一个解法没啥区别。
     * 但是出现了一个超内存的错误，原来是传入的 k 值会非常大，dp 数组太大了。现在想想，交易次数 k 最多有多大呢？
     *
     * 一次交易由买入和卖出构成，至少需要两天。
     * 所以说有效的限制 k 应该不超过 n/2，如果超过，就没有约束作用了，相当于 k = +infinity。这种情况是之前解决过的。
     * @param k
     * @param prices
     * @return
     */
    private static int maxProfit_k_any(int k, int[] prices) {

        if(prices.length == 0)
            return 0;

        int n = prices.length;
        if (k > n / 2)
            return maxProfit_k_inf_v2(prices);

        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++)
            for (int temp_k = k; temp_k >= 1; temp_k--) {
                if (i - 1 == -1) {

                    /**
                     *
                     * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+price[i])
                     * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-price[i])
                     *
                     * dp[0][k][0] = max(dp[-1][k][0] = 0,dp[-1][k][1]+price[0] = -infinity) = 0
                     * dp[0][k][1] = max(dp[-1][k][1] = -infinity, dp[-1][k-1][0]-price[i] = -price[0]) = -price[0]
                     */
                    dp[0][temp_k][0] = 0;
                    dp[0][temp_k][1] = -prices[0];
                    continue;
                 }
                dp[i][temp_k][0] = Math.max(dp[i-1][temp_k][0], dp[i-1][temp_k][1] + prices[i]);
                dp[i][temp_k][1] = Math.max(dp[i-1][temp_k][1], dp[i-1][temp_k-1][0] - prices[i]);
            }
        return dp[n - 1][k][0];
    }

    /**
     * 根据上面可以推出只和前面一天有关联，故可以用递推来解决
     *
     * @param prices
     * @return
     */
    private static int maxProfit_k_inf_v2(int[] prices) {

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


        //2
        //[3,2,6,5,0,3]
        int k =2;
        int[] prices = new int[]{3,2,6,5,0,3};

        System.out.println(maxProfit_k_any(k,prices));

    }

}
