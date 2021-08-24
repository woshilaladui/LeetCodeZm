package com.whut.algorithm.high.frequence.dynamicPlaning.problem1312_minimum_insertion_steps_to_make_a_string_palindrome;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/18 18:20
 * @desription
 */
public class MinimumInsertionStepsToMakeAStringPalindrome {

    /**
     * 在此基础上改进题目：要求只能在字符串后面加入字符使得其可以成为回文串
     *
     * @param s
     * @return
     */
    private static int minInsertions1(String s) {

        int min = s.length() - 1;

        //注意看以当前中心的回文串能否到达最后
        for (int i = s.length() - 1; i >= (s.length() - 1) / 2; i--) {

            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            //判断以当前一个结点为中心能否到达最后结点
            if (len1 / 2 + i + 1 == s.length()) {
                min = Math.min(len1,s.length()-len1);
            }

            if(len2 /2 + i + 1 == s.length()){
                min = Math.min(len2,s.length()-len2);
            }

        }

        return min;
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while ((left >= 0 && right < s.length()) && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

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
