package com.whut.algorithm.high.frequence.dynamicPlaning.bag;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/26 15:31
 * @desription
 */

/**
 * 完全背包
 */
public class BagPerfect {

    /**
     * 一维数组压缩存储
     * @param weight
     * @param value
     * @param capacity
     * @param nums
     * @return
     */
    private static int maxValue2(int[] weight, int[] value, int capacity, int nums) {

        int[] dp = new int[capacity + 1];

        for (int i = 1; i <= nums; i++) {

            for (int j = 1; j <= capacity; j++) {
                //用的是新的数据，必须新的数据去覆盖旧的数据
                if (j >= weight[i])
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }

        }//end for
        return dp[capacity];
    }

    /**
     * 二维数组的完全背包
     *
     * @param weight
     * @param value
     * @param capacity
     * @param nums
     * @return
     */
    private static int maxValue1(int[] weight, int[] value, int capacity, int nums) {

        int[][] dp = new int[nums + 1][capacity + 1];

        for (int i = 1; i <= nums; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < weight[i])
                    dp[i][j] = dp[i - 1][j];
                else
                /**
                 * dp[i][j-weight[i]]+value[i] 当前背包可以放的下更多个weight[i],扫描前面的
                 * dp[6] ->dp[3]
                 *
                 */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
            }
        }

        return dp[nums][capacity];
    }

    public static void main(String[] args) {

        int[] weight = new int[]{0, 2, 3, 4, 7};
        int[] value = new int[]{0, 1, 3, 5, 9};
        int nums = weight.length - 1;
        int capacity = 10;

        System.out.println("maxValue1 = " + maxValue1(weight, value, capacity, nums));

        System.out.println("maxValue2 = " + maxValue2(weight, value, capacity, nums));
    }

}
