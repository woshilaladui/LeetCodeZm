package com.whut.algorithm.high_frequence.problem5_longest_palindromic_substring;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/9 20:06
 * @desription
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {

        int n = s.length();

        char[] arrayS = s.toCharArray();

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = true;

        int start = 0;
        int end = 0;
        int maxLen = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (arrayS[i] == arrayS[j]) {
                    /**
                     * 1. a
                     * 2. aa
                     */
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        //第三种情况 超过2个 字符
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                    if (dp[i][j] && j - i + 1 > maxLen) {
                        start = i;
                        end = j;
                        maxLen = j - i + 1;
                    }

                }
            }
        }

        System.out.println(start);
        System.out.println(end);


        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
//        String s = "a";
//
//        String result = longestPalindrome(s);
//
//        System.out.println(result);


        String test = "a b c d     aa             ";

        String[] s1 = test.split(" ");


        for (String s2 : s1) {
            System.out.println(s2);
        }

    }

}
