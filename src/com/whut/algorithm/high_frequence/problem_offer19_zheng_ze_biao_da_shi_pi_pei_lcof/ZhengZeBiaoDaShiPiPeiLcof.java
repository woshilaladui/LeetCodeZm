package com.whut.algorithm.high_frequence.problem_offer19_zheng_ze_biao_da_shi_pi_pei_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/18 11:54
 * @desription
 */
public class ZhengZeBiaoDaShiPiPeiLcof {

    public boolean isMatch(String s, String p) {

        char[] arrayS = s.toCharArray();
        char[] arrayP = p.toCharArray();

        int lenS = s.length();
        int lenP = p.length();

        /**
         * dp[i][j]  代表s(0,i-1) 与 p(0,j-1) 是否匹配
         */
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];

        //base case
        /**
         *
         * dp[0][0] = true
         *
         * "b*" -> ""
         *
         * dp[0][i] = dp[0][i-2]
         *
         * dp[i][0] = false
         *
         */
        dp[0][0] = true;
        for (int i = 1; i <= lenP; i++) {
            if (arrayP[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];
        }

        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenP; j++) {
                if (arrayS[i - 1] == arrayP[j - 1] || arrayP[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (arrayP[j - 1] == '*') {
                    if (arrayS[i - 1] == arrayP[j - 2] || arrayP[j - 2] == '.') {

                        /**
                         *
                         * dp[i][j-2] 匹配0个
                         *
                         * s: b a a a
                         * p: b a a a a *
                         *
                         *
                         * dp[i][j-1] 匹配1个
                         * s: b a a a
                         * p: b a a a *
                         *
                         * dp[i-1][j]匹配多个
                         * s: b a a a
                         * p: b a a *
                         *
                         */

                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    } else {
                        //不匹配
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }

        return dp[lenS][lenP];
    }

    public static void main(String[] args) {

    }
}
