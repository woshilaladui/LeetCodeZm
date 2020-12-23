package com.whut.algorithm.dynamicPlaning.problem70_climbing_stairs;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/23 16:31
 * @desription
 */
public class ClimbingStairs {


    public static int climbStairs(int n) {

        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        if (n == 2)
            return 2;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }


        return dp[n];

    }

    //递归爬楼梯
    public static int climbStairs2(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    public static void main(String[] args) {


        System.out.println(climbStairs2(3));

    }

}
