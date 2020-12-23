package com.whut.algorithm.dynamicPlaning.problem121_best_time_to_buy_and_sell_stock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/30 15:20
 * @desription
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {

        if (prices.length == 0)
            return 0;

        int min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] > prices[i - 1]) {
                //后一天的价格高于前一天，可以卖，取当前买入的最低价格Min,和当前价格只差 和 前面计算的最大利润进行比较，取大的利润
                profit = Math.max(prices[i] - min, profit);
            } else {
                min = Math.min(min, prices[i]);
            }
        }

        return profit;
    }

    public static void main(String[] args) {

        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

}
