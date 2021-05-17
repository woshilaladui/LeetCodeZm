package com.whut.algorithm.dynamicPlaning.problem1312_minimum_insertion_steps_to_make_a_string_palindrome;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/18 18:20
 * @desription
 */
public class MinimumInsertionStepsToMakeAStringPalindrome {

    private static int minInsertions(String s) {
        int n = s.length();

        char[] c = s.toCharArray();

        // 定义：对 s[i..j]，最少需要插入 dp[i][j] 次才能变成回文
        int[][] dp = new int[n][n];

        //初始化
        //dp[n][n] 都为0
        //类式于516题
        //base case：i == j 时 dp[i][j] = 0，单个字符本身就是回文
        //dp 数组已经全部初始化为 0，base case 已初始化
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (c[i] == c[j]) {
                    //dp[i+1][j-1] 为回文串 且s.i == s.j
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            dp[i + 1][j],
                            dp[i][j - 1]
                    ) + 1;
                }
            }//end for
        }//end for

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "aba";

        System.out.println(minInsertions(s));
    }

}
