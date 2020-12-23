package com.whut.algorithm.dynamicPlaning.sub_string.problem674_LIS_longest_continuous_increasing_subsequence;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/7 17:17
 * @desription
 */
public class LongestContinuousIncreasingSubsequence {

    private static int findLengthOfLCIS(int[] nums) {

        if (nums.length == 0)
            return 0;

        int n = nums.length;
        //dp[i]代表0-i下的LCIS长度
        int[] dp = new int[n];

        int max_length = 1;

        //初始化
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1])
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = 1;//不满足则说明0-i不能构成

            max_length = Math.max(max_length, dp[i]);
        }

        return max_length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 4, 7};
        System.out.println(findLengthOfLCIS(nums));
    }
}
