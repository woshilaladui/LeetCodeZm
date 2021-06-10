package com.whut.algorithm.high.frequence.dynamicPlaning.problem322_coin_change;

import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/24 14:42
 * @desription
 */
public class CoinChange {

    private static int preInit(int[] coins, int amount) {

        int[] weight = new int[coins.length + 1];

        for (int i = 1; i < weight.length; i++)
            weight[i] = coins[i - 1];


        return doCoinChange(weight, amount);

    }

    /**
     * [1,2,5]
     * <p>
     * F(7) = min{F(7-1),F(7-2),F(7-5)} + 1 (其中这个1代表使用1，2，5这个纸币)
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange1(int[] coins, int amount) {
        int max = amount + 1;

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, max);

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }

        //dp[amount] = max 说明 不能兑换
        return dp[amount] == max ? -1 : dp[amount];
    }

    /**
     * @param coins
     * @param amount
     * @return
     */
    private static int doCoinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        int[] dp = new int[amount + 1];

        //初始化
        for (int i = 0; i <= amount; i++)
            dp[i] = 99999;

        dp[0] = 0;

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i])
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        return dp[amount] == 99999 ? -1 : dp[amount];
    }

    //采用一位压缩
    private static int coinChange3(int[] coins, int amount) {
        return 0;

    }

    //采用二维数组
    private static int coinChange2(int[] coins, int amount) {

        if (amount == 0)
            return 0;

        int[][] dp = new int[coins.length][amount + 1];

        Arrays.sort(coins);

        //初始化
        //当选择前0个物品的时候无法构成任何硬币
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = 999999;
        }


        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {

                //放得下
                if (j >= coins[i]) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                } else
                    dp[i][j] = dp[i - 1][j];

            }
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {

                System.out.print("dp[" + i + "][" + j + "] = " + dp[i][j] + "   ");

            }
            System.out.println();
        }

        return dp[coins.length - 1][amount] == 999999 ? -1 : dp[coins.length - 1][amount];
    }

    //用数组压缩了
    private static int coinChange(int[] coins, int amount) {


        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];

        Arrays.sort(coins);

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;


        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                //类式完全背包
                //防止有的硬币不能用其他硬币换成
                //dp[i - coins[j]]<Integer.MAX_VALUE
                if (i - coins[j] >= 0 && dp[i - coins[j]] < Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];

    }

    public static void main(String[] args) {

        //int[] coins = new int[]{186,419,83,408};
//        int[] coins = new int[]{83, 186, 408, 419};
//        int amount = 6249;
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;

        System.out.println(preInit(coins, amount));

    }
}
