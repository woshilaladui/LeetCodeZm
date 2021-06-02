package com.whut.algorithm.high.frequence.string.dynamicPlaning.problem583_delete_operation_for_two_strings;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/7 15:47
 * @desription
 */
public class DeleteOperationForTwoStrings {

    public int minDistance(String word1, String word2) {
        int lcs = longestCommonSubsequence(word1, word2);

        return word1.length() - lcs + word2.length() - lcs;
    }

    private static int longestCommonSubsequence(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        char[] arrayWord1 = word1.toCharArray();
        char[] arrayWord2 = word2.toCharArray();

        int[][] dp = new int[len1 + 1][len2 + 1];

        /**
         * dp[0][0] = 0
         * dp[0][i] = 0
         * dp[i][0] = 0
         */
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (arrayWord1[i - 1] == arrayWord2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }


    public static void main(String[] args) {

    }
}
