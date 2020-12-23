package com.whut.algorithm.dynamicPlaning.problem309_best_time_to_buy_and_sell_stock_with_cooldown;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/25 15:55
 * @desription
 */
public class BestTimeToBuyAndSellStockWithCooldown {



    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) return 0;

        // 定义状态变量
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        // 寻常
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < prices.length; i++) {
            // 状态转移方程
            // 第i天只能是买或者cooldown
            // 如果买利润就是sell[i - 2] - prices[i], 注意这里是i - 2，不是 i-1 ，因为有cooldown的限制
            // cooldown就是buy[i -1]
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            // 第i天只能是卖或者cooldown
            // 如果卖利润就是buy[i  -1] + prices[i]
            // cooldown就是sell[i -1]
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        int temp = Math.max(buy[prices.length - 1], sell[prices.length - 1]);

        return Math.max(temp,0);
        //return 0;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,1,9,1};

        System.out.println(maxProfit(prices));
    }

}
