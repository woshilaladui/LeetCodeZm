package com.whut.algorithm.dynamicPlaning.problem518_coin_change_2;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/26 16:46
 * @desription
 */
public class CoinChange2 {


    private static int change2(int amount, int[] coins) {
        int N = amount + 1;
        int[] weight = new int[coins.length + 1];

        for (int i = 1; i < weight.length; i++)
            weight[i] = coins[i - 1];

        //压缩为一维数组
        int[] dp = new int[N];

        //集合二维数组 上下挤压
        dp[0] = 1;

        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j < N; j++) {
                //dp[i] = dp[i] + dp[i - coin];
                if (j >= weight[i])
                    dp[j] += dp[j - weight[i]];
            }
        }

        return dp[amount];


    }

    private static int change(int amount, int[] coins) {

        int N = amount + 1;
        int[] weight = new int[coins.length + 1];

        for (int i = 1; i < weight.length; i++)
            weight[i] = coins[i - 1];

        int[][] dp = new int[weight.length][N];

        //初始化
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j != 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {//当为0元的时候，直接不拿相当于1种方案
                    dp[i][j] = 1;
                } else if (j % weight[i] == 0) { //能刚好整除为一种方案
                    dp[i][j] = 1;
                }
            }
        }

        //动态规划
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j < N; j++) {
                if (j >= weight[i])
                    //当前前i-1个硬币的组合+拿该硬币的组合
                    dp[i][j] = dp[i - 1][j] + dp[i][j - weight[i]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[coins.length][amount];
    }

    public static void main(String[] args) {

        int amount = 5;
        int[] coins = new int[]{1, 2, 5};

        System.out.println(change2(amount, coins));

    }

}
