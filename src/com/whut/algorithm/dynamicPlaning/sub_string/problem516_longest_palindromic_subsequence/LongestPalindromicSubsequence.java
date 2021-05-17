package com.whut.algorithm.dynamicPlaning.sub_string.problem516_longest_palindromic_subsequence;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/6 15:46
 * @desription
 */
public class LongestPalindromicSubsequence {


    private static int longestPalindromeSubseq(String s) {

        //dp[i][j]  代表s[i...j]之间能够组成的最大回文序列

        int n = s.length();

        char[] str = s.toCharArray();

        int[][] dp = new int[n][n];
        //i = j时候说明只有一个字符，就是回文串 返回1
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;

        /**
         *
         * dp[i][j] 于dp[i+1][j-1] dp[i+1][j] dp[i][j-1]
         *
         *
         * dp[i][j-1]    dp[i][j]
         * dp[i+1][j-1] dp[i+1][j]
         *
         *
         * 选择从下往上遍历
         *
         * 反着遍历，详情见md文件解析
         *
         */

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {

                if (str[i] == str[j])
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(
                            dp[i][j - 1],
                            dp[i + 1][j]
                    );

            }


        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {

        String s = "bbbab";

        System.out.println(longestPalindromeSubseq(s));

    }

}
