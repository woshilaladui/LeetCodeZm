package com.whut.algorithm.dynamicPlaning.sub_string.problem1027_longest_arithmetic_subsequence;

import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/8 16:46
 * @desription 和leetcode 300 类式，多了一个维度来维护diff 公差选项
 */
public class LongestArithmeticSubsequence {

    private static int longestArithSeqLength(int[] A) {

        if (A.length == 0)
            return 0;

        int n = A.length;

        int[][] dp = new int[n][20001];

        int diff ;
        int offset = 10000;//偏移量
        int max_length = 1;
        //初始化
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //因为公差可能为负数
                diff = A[i] - A[j];
                diff += offset;
                dp[i][diff] = dp[j][diff] + 1;
                max_length = Math.max(max_length, dp[i][diff]);
                //dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                //max_length = Math.max(dp[i][diff], max_length);

            }

        }

        return max_length;
    }

    public static void main(String[] args) {

        int[] A = new int[]{9,4,7,2,10};

        System.out.println(longestArithSeqLength(A));
    }

}
