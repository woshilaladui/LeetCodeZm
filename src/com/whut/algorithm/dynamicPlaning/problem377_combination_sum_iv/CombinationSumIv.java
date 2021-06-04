package com.whut.algorithm.dynamicPlaning.problem377_combination_sum_iv;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/1 17:03
 * @desription
 */
public class CombinationSumIv {


    /**
     *
     * 思想：与零钱兑换问题1相似
     *
     * 采用拆解
     *
     * dp[4] = 所有数字组合成target = 4的可能性
     *
     * 4= 1+3 其中 3可以理解为 3用[1,2,3]组合成3的组合数  其中又可以递推3 = 1+2 2可以理解为2 用[1，2，3]组合成2的组合数字
     *
     * @param nums
     * @param target
     * @return
     */
    private static int combinationSum4_3(int[] nums, int target) {

        // 数组长度
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        // 1.初始化dp数组 dynamic programming
        int[] dp = new int[target + 1];
        // 恰在Nums数组中存在一个数target相等 为1种可能
        //eg i = 1时候 dp[1] =dp[1] + dp[1-nums[j]] = dp[1] + dp[0]  此时dp[1] = 0 dp[0] = 1
        dp[0] = 1;
        // 动态规划
        // 2.遍历目标正整数 i的意思是当前的目标正整数

        /**
         * 为什么target在外层循环，因为组合问题，且考虑元素顺序，112 和211是不同的，所以target放在外层
         */
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num)
                    // dp[i]= dp[i - nums[0]] + dp[i - nums[1]] + dp[i - nums[2]] + ...
                    dp[i] += dp[i - num];
            }
        }

        //
        for(int i=0;i<=target;i++)
            System.out.print(dp[i]+" ");
        System.out.println();

        return dp[target];

    }


    /**
     * 不允许有重复的集合
     * <p>
     * 112->121是一样的东西
     *
     * @param nums
     * @param target
     * @return
     */
    private static int combinationSum4_2(int[] nums, int target) {

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            //完全背包
            for (int j = 1; j <= target; j++)
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }

        }

        for (int i = 0; i < dp.length; i++)
            System.out.print("->" + dp[i]);

        return dp[target];
//        int n = nums.length;
//        int[] dp = new int[target + 1];
//        dp[0] = 1;
//        for (int i = 1; i <= target; i++) {
//            for (int j = 1; j <= n; j++) {
//                int w = nums[j - 1];
//                if (i >= w)
//                    dp[i] = dp[i] + dp[i - w];
//            }
//        }
//        for (int i = 0; i < dp.length; i++)
//            System.out.print("->" + dp[i]);
//        return dp[target];
    }


    /**
     * 用回溯会超时间
     * <p>
     * 相当于完全背包问题
     * 先采用二维数组
     * <p>
     * 不允许有重复 121 ->112 ->211 是一样的东西
     *
     * @param nums
     * @param target
     * @return
     */
    public static int combinationSum4_1(int[] nums, int target) {

        int[][] dp = new int[nums.length][target + 1];

        //初始化
        //相当于选前i个组成0的可能性，不选即可
        for (int i = 0; i < nums.length; i++)
            dp[i][0] = 1;

//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 1; j <= target; j++) {
//                if (j >= nums[i])
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - nums[i]];
//                else
//                    dp[i][j] = dp[i - 1][j];
//            }
//        }

        for (int j = 1; j <= target; j++) {
            for (int i = 1; i < nums.length; i++) {
                if (j >= nums[i])
                    dp[i][j] = dp[i - 1][j] + dp[i][j - nums[i]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[nums.length - 1][target];
    }


    public static void main(String[] args) {

        int[] nums = new int[]{ 1, 2, 3};
        int target = 3;
        System.out.println();
        System.out.println(combinationSum4_3(nums, 0));

    }
}
