package com.whut.algorithm.high.frequence.string.dynamicPlaning.problem10_regular_expression_matching;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/7 15:05
 * @desription
 */
public class RegularExpressionMatching {

    /**
     * 以一个例子详解动态规划转移方程：
     * S = abbbbc
     * P = ab*d*c
     * 1. 当 i, j 指向的字符均为字母（或 '.' 可以看成一个特殊的字母）时，
     *    只需判断对应位置的字符即可，
     *    若相等，只需判断 i,j 之前的字符串是否匹配即可，转化为子问题 f[i-1][j-1].
     *    若不等，则当前的 i,j 肯定不能匹配，为 false.
     *
     *        f[i-1][j-1]   i
     *             |        |
     *    S [a  b  b  b  b][c]
     *
     *    P [a  b  *  d  *][c]
     *                      |
     *                      j
     *
     *
     * 2. 如果当前 j 指向的字符为 '*'，则不妨把类似 'a*', 'b*' 等的当成整体看待。
     *    看下面的例子
     *
     *             i
     *             |
     *    S  a  b [b] b  b  c
     *
     *    P  a [b  *] d  *  c
     *             |
     *             j
     *
     *    注意到当 'b*' 匹配完 'b' 之后，它仍然可以继续发挥作用。
     *    因此可以只把 i 前移一位，而不丢弃 'b*', 转化为子问题 f[i-1][j]:
     *
     *          i
     *          | <--
     *    S  a [b] b  b  b  c
     *
     *    P  a [b  *] d  *  c
     *             |
     *             j
     *
     *    另外，也可以选择让 'b*' 不再进行匹配，把 'b*' 丢弃。
     *    转化为子问题 f[i][j-2]:
     *
     *             i
     *             |
     *    S  a  b [b] b  b  c
     *
     *    P [a] b  *  d  *  c
     *       |
     *       j <--
     *
     * 3. 冗余的状态转移不会影响答案，
     *    因为当 j 指向 'b*' 中的 'b' 时, 这个状态对于答案是没有用的,
     *    原因参见评论区 稳中求胜 的解释, 当 j 指向 '*' 时,
     *    dp[i][j]只与dp[i][j-2]有关, 跳过了 dp[i][j-1].
     *
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        int lenS = s.length();
        int lenP = p.length();

        char[] charrayS = s.toCharArray();
        char[] charrayP = p.toCharArray();

        /**
         * S的前i个字符是否和P的前j个字符匹配
         */
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];

        //初始化
        dp[0][0] = true;

        /**
         *
         * dp[0][0]
         *
         * dp[i][0] = false
         * dp[0][i] - > = dp[0][i-2]  b* 作为一个整体
         *
         */
        for (int i = 1; i <= lenP; i++) {
            if (charrayP[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];
        }


        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenP; j++) {
                if(charrayS[i-1] == charrayP[j-1] || charrayP[j-1] == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(charrayP[j-1] == '*'){
                    //'.' 等于任意字符
                    if(charrayS[i-1] == charrayP[j-2] || charrayP[j-2] == '.'){
                                   //匹配多个    匹配1个       匹配0个
                        dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i][j-2];
                    }else {
                        //跳过 b*
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }

        return dp[lenS][lenP];
    }

    public static void main(String[] args) {

    }
}
