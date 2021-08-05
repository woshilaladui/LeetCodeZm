package com.whut.algorithm.high.frequence.common.problem62_unique_paths;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/14 19:27
 * @desription
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {

        /**
         * dp[i][j] 代表从左上角到i,j不同路径的个数
         *
         * dp[i][j] = dp[i][j-1] + dp[i-1][j]
         *
         */
        int[][] dp = new int[m][n];

        /**
         * 初始化
         * dp[i][0] = 1
         * dp[0][i] = 1
         */
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {

    }
}
