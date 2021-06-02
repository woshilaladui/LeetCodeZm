package com.whut.algorithm.high.frequence.string.dynamicPlaning.problem718_maximum_length_of_repeated_subarray;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/7 15:28
 * @desription
 */
public class MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] A, int[] B) {

        int lenA = A.length;
        int lenB = B.length;

        //代表A的前i个数字和B的前j个数字组成最大的公共数组长度
        int[][] dp = new int[lenA + 1][lenB + 1];

        int reslut = 0;

        /**
         *
         * dp[0][0]  = 0
         * dp[0][i] = 0
         * dp[i][0] = 0;a
         *
         */
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                reslut = Math.max(reslut, dp[i][j]);
            }


        }

        return reslut;
    }

    public static void main(String[] args) {

    }
}
