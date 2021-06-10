package com.whut.algorithm.high.frequence.dynamicPlaning.sub_string.problem1143_LCS_longest_common_subsequence;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/4 17:25
 * @desription
 */
public class LongestCommonSubsequence {

    private static int longestCommonSubsequence(String text1, String text2) {

        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int length1 = text1.length();
        int length2 = text2.length();

        //其中dp[i][j] 代表t1的从1开始的字符到第i个字符（不是下标）,t2从第1个字符到第j个字符能组成的最大公共序列
        int[][] dp = new int[length1 + 1][length2 + 1];
        //i表示第i个字符，不是下标
        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {

                //如果第i个字符和t2的第j个字符相等（对应下标是i-1,j-1）
                if (t1[i - 1] == t2[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(
                            dp[i][j-1],
                            dp[i-1][j]
                    );
            }
        }


        return dp[length1][length2];
    }

//    public static int longestCommonSubsequence(String text1, String text2) {
//
//        int[][] dp = new int[text1.length()][text2.length()];
//
//        //初始化
//        //dp[i][0] = 0;
//        //dp[0][i] = 0;
//
//        for (int i = 0; i < text1.length(); i++) {
//            for (int j = 0; j < text2.length(); j++) {
//
//                if (i == 0 || j == 0) {
//                    //初始化
//                    if (text1.charAt(i) == text2.charAt(j))
//                        dp[i][j] = 1;
//                    else {
//                        dp[i][j] = Math.max(
//                                i == 0 ? 0 : dp[i - 1][j],
//                                j == 0 ? 0 : dp[i][j - 1]
//                        );
//                    }
//
//
//                    continue;
//                }
//
//                if (text1.charAt(i) == text2.charAt(j)) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else
//                    dp[i][j] = Math.max(
//                            dp[i - 1][j],
//                            dp[i][j - 1]
//                    );
//
//            }
//        }
//
//
//        return dp[text1.length() - 1][text2.length() - 1];
//    }

    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "ace";

        System.out.println(longestCommonSubsequence(text1, text2));

    }

}
