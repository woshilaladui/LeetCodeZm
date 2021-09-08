package com.whut.interview.xiaopi.problem1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/6 19:21
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        int V = 24;
        int[] nums = new int[]{ 8, 3, 12, 7, 9, 7};
        System.out.println(bestFit(V, nums));
    }

    private static int bestFit(int V, int[] nums) {
        int[] dp = new int[V + 1];


        for (int i = 1; i <= nums.length-1 ; i++) {
            for (int j = V; j >= 1; j--) {
                //放的下
                if (j >= nums[i-1])
                    dp[j] = Math.max(dp[j], dp[j - nums[i-1]] + nums[i-1]);
            }
        }
        return V - dp[V];
    }
}
