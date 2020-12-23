package com.whut.algorithm.dynamicPlaning.problem53_maximum_subarray;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/23 17:19
 * @desription
 */
public class MaximumSubarray {


    //动态规划
    private static int maxSubArray(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        int maxSum = nums[0];

        //dp[i] = max(dp[i-1]+nums[i],nums[i])
        for (int i = 1; i < nums.length; i++) {

            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);

            maxSum = Math.max(maxSum,dp[i]);

        }

        return maxSum;


    }

    /**
     * 分治法
     * @param nums
     * @return
     */
    private static int maxSubArray2(int[] nums){

        return 0;

    }

    public static void main(String[] args) {

        /**
         * [-2,1,-3,4,-1,2,1,-5,4]
         * 连续子数组 [4,-1,2,1] 的和最大，为 6。
         */

        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums));

    }

}
