package com.whut.algorithm.dynamicPlaning.problem494_target_sum;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/1 14:15
 * @desription
 */
public class TargetSum {


    /**
     * 采用一维数组压缩
     *
     * @param nums
     * @param target
     * @return
     */
    private static int sumCount2(int[] nums, int target) {

        int[] dp = new int[target + 1];

        //初始化
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            //相当于0/1背包问题
//            for(int j=target;j>=1;j--){
//                if(j>=nums[i])
//                    dp[j]+=dp[j-nums[i]];
//            }

            //改造上面减少判断
            for (int j = target; j >= nums[i]; j--) {
                    dp[j] += dp[j - nums[i]];
            }
        }

        return dp[target];
    }

    /**
     * 二维数组
     *
     * @param nums
     * @param target
     * @return
     */
    private static int sumCount1(int[] nums, int target) {

        int[][] dp = new int[nums.length][target + 1];

        //初始化
        //前i个物品构成0组合为1次，即什么都不选择
        for (int i = 0; i < nums.length; i++)
            dp[i][0] = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i])
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[nums.length - 1][target];
    }

    //找零钱问题
    private static int findTargetSumWays(int[] nums, int S) {

        //定义 对于一个数组
        /**
         *
         * 有 1.sum(positive) -sum(negative) = target
         *    2.sum(positive)+sum(negative) + sum(positive) -sum(negative) = target + sum(positive)+sum(negative)
         *                           2*sum(positive)          = target +sum
         *                           sum(positive)            = (target+sum)/2
         *  其中sum(positive)  一定为整数，说明(target + sum)/2一定为偶数
         *  并且sum>=target
         *
         */


        int sum = Arrays.stream(nums).sum();

        if (sum < S)
            return 0;
        if ((S + sum) % 2 == 1) return 0;

        return sumCount2(nums, (S + sum) / 2);

    }

    public static void main(String[] args) {


//        int[] nums = new int[]{0,0,0,0,0,0,0,0,1};
//        int S = 1;
//        System.out.println(findTargetSumWays(nums, S));
        System.out.println(sumCount2(new int[]{1,1,1,1,1},0));

    }
}
