package com.whut.algorithm.high.frequence.dynamicPlaning.bag;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/26 16:06
 * @desription
 */
public class BagMuti {

    /**
     * 多重背包的最大值
     *
     * @param weight
     * @param value
     * @param sums
     * @param capacity
     * @param nums
     * @return
     */
    private static int maxValue(int[] weight, int[] value, int[] sums, int capacity, int nums) {

        int[] dp = new int[capacity + 1];

        for (int i = 1; i <= nums; i++) {
            if (capacity <= sums[i] * weight[i])//转化为0/1背包问题，该物品数量多，足够把该背吧塞满
                CompletePack(weight[i], value[i], dp, capacity);
            else {

                //这里采用二进制思想
                /**
                 * 1 2 4 8 16 当需要6个物品的时候
                 * 4 + (6-4) = 6 不用一个
                 */
                int k = 1;
                while (k <= sums[i]) {
                    ZeroOnePack(k * weight[i], k * value[i], dp, capacity);
                    sums[i] -= k;
                    k *= 2;
                }
                ZeroOnePack(sums[i] * weight[i], sums[i] * value[i], dp, capacity);

            }
        }

        return dp[capacity];
    }


    private static void ZeroOnePack(int weight, int value, int[] dp, int capacity) {//01背包
        for (int i = capacity; i >= 1; i--) {
            if (i >= weight)
                dp[i] = Math.max(dp[i], dp[i - weight] + value);
        }
    }

    private static void CompletePack(int weight, int value, int[] dp, int capacity) {//完全背包
        for (int i = 1; i <= capacity; i++) {
            if (i >= weight)
                dp[i] = Math.max(dp[i], dp[i - weight] + value);
        }
    }


    public static void main(String[] args) {


        int capacity = 1000;
        int nums = 5;
        int[] weight = new int[]{0, 80, 40, 30, 40, 20};
        int[] value = new int[]{0, 20, 50, 50, 30, 20};
        int[] sums = new int[]{0, 4, 9, 7, 6, 1};

        System.out.println("maxValue = " + maxValue(weight, value, sums, capacity, nums));

    }

}
