package com.whut.interview.xiaohongshu.problem1;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/4 10:13
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] nums = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        System.out.println(getMaxPoint(nums));
    }

    private static int getMaxPoint(int[][] nums) {
        int[][] dp = new int[nums.length][nums.length];
        int max = Integer.MIN_VALUE;
        dp[0][0] = nums[0][0];
        dp[0][1] = Math.max(dp[0][0] + nums[0][1], nums[0][1]);
        max = Math.max(dp[0][1], max);
        dp[1][0] = Math.max(dp[0][0] + nums[1][0], nums[1][0]);
        max = Math.max(dp[1][0], max);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                dp[i][j] = getMax(new int[]{
                        dp[i][j - 1] + dp[i - 1][j] + nums[i][j] - dp[i - 1][j - 1],
                        dp[i][j - 1],
                        dp[i - 1][j],
                        nums[i][j]
                });
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    private static int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i],max);
        }
        return max;
    }
}
