package com.whut.algorithm.dynamicPlaning.problem122_best_time_to_buy_and_sell_stock_ii;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/30 15:32
 * @desription
 */
public class BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {

        if (prices.length == 0)
            return 0;

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            //只要后一天的价格比前一天的价格高就卖出
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];

        }

        return profit;
    }

    public static void main(String[] args) {

        int[] prices = new  int[]{1,2,3,2,5};

        System.out.println(maxProfit(prices));
    }

}
