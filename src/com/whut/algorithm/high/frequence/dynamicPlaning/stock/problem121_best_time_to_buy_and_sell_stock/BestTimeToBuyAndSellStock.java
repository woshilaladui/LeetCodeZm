package com.whut.algorithm.high.frequence.dynamicPlaning.stock.problem121_best_time_to_buy_and_sell_stock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/2 15:30
 * @desription
 */
public class BestTimeToBuyAndSellStock {


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
     *
     * 采用二维数组来解题
     *
     * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+price[i])
     * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-price[i])
     *
     * 当k等于1时
     *
     * dp[i][1][0] = max(dp[i-1][1][0],dp[i-1][k][1]+price[i])
     * dp[i][1][1] = max(dp[i-1][1][1],dp[i-1][0][0]-price[i])
     * dp[i][1][1] = max(dp[i-1][1][1],-price[i])
     *
     * 中间的k这个数组可以丢弃
     * dp[i][0] = max(dp[i-1][0],dp[i-1][1]+price[i])
     * dp[i][1] = max(dp[i-1][1],-price[i])
     *
     * 初始化
     * dp[0][0] = max(dp[-1][0] = 0,dp[-1][1]+price[0] = -infinity) = 0
     * dp[0][1] = max(dp[-1][1],-price[0]) = -price[1];
     *
     *
     * @param prices
     * @return
     */
    private static int maxProfit_k_1_v1(int[] prices){

        if(prices.length == 0)
            return 0;

        int n = prices.length;

        int[][]dp = new int[n][2];

        for(int i=0;i<n;i++){

            //初始化
            if(i == 0){
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);

        }

        //最后肯定是0 代表把所有股票卖出去了，即手中不会存留股票
        return dp[n-1][0];
    }

    /**
     * 观察后新状态只和前一个状态有关，所以可以用递推思想来减少空间的利用
     * @param prices
     * @return
     */
    private static int maxProfit_k_1_v2(int[] prices){

        if(prices.length == 0)
            return 0;

        int n = prices.length;

//        dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
//        dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;//第一天没有收益

        for(int i=0;i<n;i++){

            //相当于状态转移 右边的dp_i_0->转移到左边dp_i_0

            dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1,-prices[i]);

        }

        //最后肯定是0 代表把所有股票卖出去了，即手中不会存留股票
        return dp_i_0;
    }


    public static void main(String[] args) {

        int[] price = new int[]{7,1,5,3,6,4};

        System.out.println(maxProfit_k_1_v2(price));

    }
}
