package com.whut.algorithm.dynamicPlaning.stock.problem123_best_time_to_buy_and_sell_stock_iii;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/2 16:15
 * @desription
 */
public class BestTimeToBuyAndSellStockIII {


    /**
     *
     * i代表天数
     * k代表购买的次数
     * 0/1代表 0代表当前手中是没有股票的，1代表手中有股票
     *
     * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+price[i])
     *               max(   选择 rest  ,    选择 sell      )
     *
     * 解释：今天我没有持有股票，有两种可能：
     * 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
     * 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
     *
     *
     * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-price[i])
     *               max(   选择 rest  ,     选择 buy         )
     *
     * 解释：今天我持有着股票，有两种可能：
     * 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
     * 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
     *
     *
     * 初始化
     *
     * dp[-1][k][0] = 0
     * 解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
     * dp[-1][k][1] = -infinity
     * 解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
     * dp[i][0][0] = 0
     * 解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
     * dp[i][0][1] = -infinity
     * 解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
     *
     *
     *
     */


    /**
     * 采用二维数组来解题
     * <p>
     * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+price[i])
     * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-price[i])
     * <p>
     * 当k等于2时
     * 需要计算k =1,k=2两种情况
     * <p>
     * k=1
     * dp[i][1][0] = max(dp[i-1][1][0],dp[i-1][1][1]+price[i])
     * dp[i][1][1] = max(dp[i-1][1][1],dp[i-1][0][0]-price[i])
     *             = max(dp[i-1][1][1],-price[i])
     * i= 0
     * dp[0][1][0] = max(dp[-1][1][0] = 0,dp[-1][1][1]+price[i]) = 0
     * dp[0][1][1] = max(dp[-1][1][1],-price[i]) = -price[0]
     * <p>
     * k=2
     * <p>
     * dp[i][2][0] = max(dp[i-1][2][0],dp[i-1][2][1]+price[i])
     * dp[i][2][1] = max(dp[i-1][2][1],dp[i-1][1][0]-price[i])
     * i=0
     * dp[0][2][0] = max(dp[-1][2][0],dp[-1][2][1]+price[0]) = 0
     * dp[0][2][1] = max(dp[-1][2][1],dp[-1][1][0]-price[0]) = -price[0]
     * <p>
     * <p>
     * 初始化
     * dp[-1][k][0] = 0
     * d[-1][k][1] = -infinity
     * dp[i][0][0] = 0
     * dp[i][0][1] = -infinity
     * dp[0][1] = max(dp[-1][1],-price[0]) = -price[1];
     *
     * @param prices
     * @return
     */
    private static int maxProfit_k_2_v1(int[] prices) {

        if (prices.length == 0)
            return 0;

        int n = prices.length;

        int max_k =2;

        int[][][] dp = new int[n][max_k+1][2];

        for (int i = 0; i < n; i++) {

            for(int k =max_k;k>=1;k--){
                if(i == 0){
                    dp[0][1][0] = 0;
                    dp[0][1][1] = -prices[0];

                    dp[0][2][0] = 0;
                    dp[0][2][1] = -prices[0];
                    continue;
                }

                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);

            }

        }

        return dp[n-1][max_k][0];

    }

    /**
     * 根据上述转移方程可以修改为递推关系式
     * @param prices
     * @return
     */
    private static int maxProfit_k_2_v2(int[] prices){

        if(prices.length == 0)
            return 0;

        int n = prices.length;

        int dp_i_1_0 = 0,dp_i_1_1 = Integer.MIN_VALUE;
        int dp_i_2_0 = 0,dp_i_2_1 = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){

//        dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
//        dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);

            dp_i_2_0 = Math.max(dp_i_2_0,dp_i_2_1+prices[i]);
            dp_i_2_1 = Math.max(dp_i_2_1,dp_i_1_0-prices[i]);

            dp_i_1_0 = Math.max(dp_i_1_0,dp_i_1_1+prices[i]);
            //k = 1时 dp[i-1][0][0] = 0
            //dp_i_1_1 = Math.max(dp_i_1_1,dp_i_1_0-prices[0]);
            dp_i_1_1 = Math.max(dp_i_1_1,-prices[i]);
        }

        return dp_i_2_0;

    }


    public static void main(String[] args) {

        int[] prices = new int[]{2,1,2,0,1};

        System.out.println(maxProfit_k_2_v2(prices));

    }

}
