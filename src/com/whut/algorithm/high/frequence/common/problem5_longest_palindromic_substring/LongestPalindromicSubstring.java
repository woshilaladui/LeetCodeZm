package com.whut.algorithm.high.frequence.common.problem5_longest_palindromic_substring;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/9 20:06
 * @desription
 */
public class LongestPalindromicSubstring {

    /**
     * 中心扩散法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {

        int maxLen = 0;

        int start = 0, end = 0;

        int tempLen = 0;

        for (int i = 0; i < s.length() - maxLen / 2; i++) {
            //中心一个点
            int len1 = expandAroundCenter(s, i, i);
            //中心两个结点
            int len2 = expandAroundCenter(s, i, i + 1);

            tempLen = Math.max(len1, len2);

            maxLen = Math.max(tempLen,maxLen);

            //计算最长长度的回文串
            if (tempLen > end - start) {
                //奇偶统一
                start = i - (tempLen - 1) / 2;
                end = i + tempLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while ((left >= 0 && right < s.length()) && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

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

        System.out.println(longestPalindrome2("babad"));

//        String test = "a b c d     aa             ";
//
//        String[] s1 = test.split(" ");
//
//
//        for (String s2 : s1) {
//            System.out.println(s2);
//        }

    }

}
