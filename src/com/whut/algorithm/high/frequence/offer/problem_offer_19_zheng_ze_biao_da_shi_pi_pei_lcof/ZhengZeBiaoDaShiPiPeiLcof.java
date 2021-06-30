package com.whut.algorithm.high.frequence.offer.problem_offer_19_zheng_ze_biao_da_shi_pi_pei_lcof;

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


    /**
     * 状态机求解
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {

        //递归返回条件

        return isMatch2(s, p, 0, 0);
    }

    public boolean isMatch2(String s, String p, int indexS, int indexP) {

        //递归返回条件
        if (indexS == s.length() && indexP == p.length())
            return true;

        if (indexS < s.length() && indexP == p.length())
            return false;

        // * 号的情况
        if (indexP != p.length() - 1 && p.charAt(indexP + 1) == '*') {
            if (indexS != s.length() - 1 && indexP != p.length() - 1 && (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.')) {
                // 去下一个状态
                //相当于出现1次
                return isMatch2(s, p, indexS + 1, indexP + 2) ||
                        //待在原处
                        //相当于复制了一次
                        isMatch2(s, p, indexS + 1, indexP) ||
                        //相当于跳过a*
                        isMatch2(s, p, indexS, indexP + 2);
            } else {
                //不相等则让他消失
                return isMatch2(s, p, indexS, indexP + 2);
            }
        }//end if

        // . 的情况
        if (indexS != s.length() - 1 && indexP != p.length() - 1 && (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.'))
            return isMatch2(s, p, indexS + 1, indexP + 1);

        return false;
    }

    public static void main(String[] args) {
        ZhengZeBiaoDaShiPiPeiLcof zhengZeBiaoDaShiPiPeiLcof = new ZhengZeBiaoDaShiPiPeiLcof();

        /**
         * "mississippi"
         * "mis*is*ip*."
         */
        System.out.println(zhengZeBiaoDaShiPiPeiLcof.isMatch2("ab", ".*c"));
    }
}
