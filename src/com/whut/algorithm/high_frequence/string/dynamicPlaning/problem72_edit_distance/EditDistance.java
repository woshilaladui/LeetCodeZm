package com.whut.algorithm.high_frequence.string.dynamicPlaning.problem72_edit_distance;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/7 16:03
 * @desription
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();

        char[] arrayWord1 = word1.toCharArray();
        char[] arrayWord2 = word2.toCharArray();

        int[][] dp = new int[len1 + 1][len2 + 1];

        /**
         *
         * dp[0][0] = 0;
         * dp[0][i] = i
         * dp[i][0] = i
         *
         */

        for(int i = 1;i <= len1;i++){
            dp[i][0] = i;
        }

        for(int i =1;i <= len2;i++){
            dp[0][i] = i;
        }


        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (arrayWord1[i - 1] == arrayWord2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j] + 1,//删除
                            Math.min(dp[i][j - 1] + 1,//插入
                                    dp[i - 1][j - 1] + 1 //跳过
                            )
                    );
                }
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {

    }
}
