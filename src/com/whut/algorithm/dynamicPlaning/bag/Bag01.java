package com.whut.algorithm.dynamicPlaning.bag;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/26 14:58
 * @desription
 */

import java.util.Arrays;

/**
 * 0/1背包问题
 */
public class Bag01 {


    /**
     * 采用一维数组
     * @param weight
     * @param value
     * @param capacity
     * @param nums
     * @return
     */
    private static int maxValue2(int[] weight, int[] value, int capacity, int nums){

        //dp数组之和前面数据有关 dp[i]<->dp[i-1]有关
        int[] dp = new int[capacity+1];

        for(int i=1;i<=nums;i++){
            //重后往前扫描,会覆盖数据
            /**
             *
             * 若从前往后扫描会出现如下:dp[1~5]代表1-5之间的数据
             * dp[5] = max(dp[5],dp[1~5])
             *
             * 将dp[5]更新了，但是后续计算dp[7]的时候需要用到dp[5]但是dp[5]被更新过，形成了脏数据
             *
             */
            for(int j=capacity;j>=1;j--){
                //放的下
                if(j>=weight[i])
                    dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }

        return dp[capacity];
    }

    /**
     * 二维数组
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

                //放不下
                if (j < weight[i])
                    dp[i][j] = dp[i - 1][j];
                else//放得下，则比较是拿的利益高还是不拿的利益高
                    //用的是旧数据，即上一行的数据
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);

            }
        }//end for

        return dp[nums][capacity];
    }

    public static void main(String[] args) {

        int[] weight = new int[]{0,2, 3, 4, 7};
        int[] value = new int[]{0,1, 3, 5, 9};
        int nums = weight.length-1;
        int capacity = 10;

        System.out.println("maxValue1 = " + maxValue1(weight, value, capacity, nums));

        System.out.println("maxValue2 = " + maxValue2(weight, value, capacity, nums));

    }

}
