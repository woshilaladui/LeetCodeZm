package com.whut.algorithm.high.frequence.dynamicPlaning.problem123_best_time_to_buy_and_sell_stock_iii;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/30 15:57
 * @desription
 */
public class BestTimeToBuyAndSellStockIII {

    //类似于309题目 定义转移方程，这个题目限定2次
    public static int maxProfit(int[] prices) {
        //b1,b2分别为第一次买入和第二次买入手中钱的最大值
        int b1 = Integer.MIN_VALUE,b2 = Integer.MIN_VALUE;
        //s1,s2分别为第一次卖出和第二次卖出手中的钱的最大值
        int s1 = 0,s2 = 0;

        for(int i=0;i<prices.length;i++){

            b1 = Math.max(b1,-prices[i]);
            s1 = Math.max(s1,b1+prices[i]);
            b2 = Math.max(b2,s1-prices[i]);
            s2 = Math.max(s2,b2+prices[i]);

        }
        return s2;

    }

    public static void main(String[] args) {

        int[] prices = new  int[]{1};

        System.out.println(maxProfit(prices));
    }
}
