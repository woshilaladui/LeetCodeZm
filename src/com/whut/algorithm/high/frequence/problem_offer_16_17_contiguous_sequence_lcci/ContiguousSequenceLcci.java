package com.whut.algorithm.high.frequence.problem_offer_16_17_contiguous_sequence_lcci;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/25 10:01
 * @desription
 */
public class ContiguousSequenceLcci {

    public static int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];

        if(nums.length == 1)
            return nums[0];

        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        //[-2,1,-3,4,-1,2,1,-5,4]
        //[-2,1,-3,4,-1,2,1,-5,4]
        int []nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
