package com.whut.algorithm.dynamicPlaning.problem198_house_robber;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/23 16:48
 * @desription
 */
public class HouseRobber {


    public static int rob(int[] nums) {

        if(nums.length == 0)
            return 0;

        if(nums.length == 1)
            return nums[0];

        if(nums.length == 2)
            return Math.max(nums[0],nums[1]);

        int[] dp = new int[nums.length];

        //初始化
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        /**
         * 状态转移方程
         *
         * 选择第i号房间则;第i个房间+前i-2个房间的最优解
         * 不选择第i号房间：就是前i-1个房间的最优解
         * dp[i] = max(dp[i-1],dp[i-2]+nums[i])
         */
        for(int i=2;i< nums.length;i++){

            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);

        }

        return dp[nums.length-1];

    }

    public static void main(String[] args) {

        int[] nums= new int[]{1,3,1};

        System.out.println(rob(nums));

    }
}
