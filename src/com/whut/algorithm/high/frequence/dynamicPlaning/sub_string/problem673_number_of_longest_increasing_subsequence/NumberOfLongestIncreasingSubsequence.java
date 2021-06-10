package com.whut.algorithm.high.frequence.dynamicPlaning.sub_string.problem673_number_of_longest_increasing_subsequence;

import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/7 16:21
 * @desription
 */
public class NumberOfLongestIncreasingSubsequence {

    //类式于leetcode 300 加一个数组container[i] 数组来表示以nums[i]结尾的LIS的个数
    private static int findNumberOfLIS(int[] nums) {

        int n = nums.length;
        int[] container = new int[n];
        int[] dp = new int[n];
        int max_length = 0;//LIS length
        int result = 0;

        Arrays.fill(dp, 1);
        Arrays.fill(container, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //可以选择或者不选择
                    if (dp[j] + 1 > dp[i]) { //出现一条更好的LIS
                        dp[i] = dp[j] + 1;
                        container[i] = container[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        container[i] += container[j];
                    }


                }//end if
            }//end for
            //更新最大长度
            max_length = Math.max(max_length, dp[i]);
            System.out.println("max_length = " + max_length);
        }//end for

        for (int i = 0; i < n; i++) {
            if (dp[i] == max_length)
                result += container[i];
        }

        return result;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{2, 2, 2, 2, 2};
        System.out.println(findNumberOfLIS(nums));

    }
}
