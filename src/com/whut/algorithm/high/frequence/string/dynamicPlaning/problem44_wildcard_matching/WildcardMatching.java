package com.whut.algorithm.high.frequence.string.dynamicPlaning.problem44_wildcard_matching;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/6 19:25
 * @desription
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {

        int len1 = s.length();
        int len2 = p.length();

        char[] charArrS = s.toCharArray();
        char[] charArrP = p.toCharArray();

        /**
         * 代表 s 的前i个字符串，和p 的前j个字符串是否匹配
         */
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        dp[0][0] = true;

        /**
         *
         * 初始化
         *
         * dp[0][0] = true
         * dp[i][0] = false
         * dp[0][j]  -> * 都为true
         *
         */
        for (int j = 1; j <= len2; j++) {
            if (charArrP[j - 1] == '*')
                dp[0][j] = true;
            else
                break;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (charArrS[i - 1] == charArrP[j - 1] || charArrP[j - 1] == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (charArrP[j - 1] == '*')
                    dp[i][j]
                            = dp[i][j - 1] // 匹配0个
                            ||
                            dp[i - 1][j];//匹配多个
            }
        }


        return dp[len1][len2];
    }

    public static void main(String[] args) {

    }
}
