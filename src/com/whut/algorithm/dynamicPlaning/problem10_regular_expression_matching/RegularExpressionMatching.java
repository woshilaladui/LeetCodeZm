package com.whut.algorithm.dynamicPlaning.problem10_regular_expression_matching;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/18 15:55
 * @desription
 */
public class RegularExpressionMatching {

    private static boolean isMatch(String s, String p) {

        if (s == null || p == null)
            return false;

        //初始化
        int sLen = s.length();
        int pLen = p.length();
        char[] c_s = s.toCharArray();
        char[] c_p = p.toCharArray();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];

        //java自动将其初始化为false
        dp[0][0] = true;

        //base case
        /**
         * 若 p 的第 j 个字符 p[j - 1] 是 '*'
         * 说明第 j - 1、j 位可有可无
         * 那么如果前 j - 2 个已经匹配上，前 j 个也可以匹配上
         */
        for (int j = 1; j <= pLen; j++) {
            if (c_p[j - 1] == '*')
                dp[0][j] = dp[0][j - 2];
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                //i,j位置相等时候，或者出现通配符. 时候查询前面是否为true
                if (c_s[i - 1] == c_p[j - 1] || c_p[j-1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (c_p[j - 1] == '*') {
                    if (c_s[i - 1] == c_p[j - 2] || c_p[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2]//匹配0个
                                ||
                                dp[i][j - 1]//匹配1个，相当于把*去掉 ab ab*
                                ||
                                dp[i - 1][j];//匹配多个
                    } else {
                        //不等相当于移除#*(其中#号代表任意字符)
                        dp[i][j] = dp[i][j - 2];
                    }

                }
            }
        }//end for

        return dp[sLen][pLen];

    }

    public static void main(String[] args) {

        String text = "aa";
        String pattern = "a*";
        System.out.println(isMatch(text, pattern));
    }
}
