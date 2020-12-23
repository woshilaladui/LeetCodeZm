package com.whut.algorithm.dynamicPlaning.sub_string.problem712_minimu_ascii_delete_sum_for_two_strings;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/6 19:11
 * @desription
 */
public class MinimunAsciiDeleteSumForTwoStrings {

    /**
     * 数组含义：dp[i][j]代表s1的前i位和s2的前j位使两个字符串相等所需删除字符的ASCII值的最小和
     * 初始化：当s1和s2分别为空时，另一个字符串需要删除全部字符
     * 状态转移：3种情况1.删掉s1的i位 2.删掉s2的j位 3.同时删掉 s1和s2的第i，j位 选择最小值
     * @param s1
     * @param s2
     * @return
     */
    private static int minimumDeleteSum(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int[][] dp = new int[len1+1][len2+1];

        //初始化
        /**
         * 当str2为空时候
         * dp[i][0]  需要累加前面的Ascii
         */
        for(int i=1;i<=len1;i++)
            dp[i][0] = dp[i-1][0] + str1[i-1];

        for(int j =1;j<=len2;j++)
            dp[0][j] = dp[0][j-1] +str2[j-1];

        for(int i=1;i<=len1;i++){
            for(int j= 1;j<=len2;j++){
                if(str1[i-1] == str2[j-1])
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(
                      dp[i][j-1] + str2[j-1],//删除str2
                      Math.min(
                              dp[i-1][j] + str1[i-1],//删除str1
                              dp[i-1][j-1] + str1[i-1]+str2[j-1]//同时删除str1 str2
                      )
                    );
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {

        String s1 = "sea";
        String s2 = "eat";

        System.out.println(minimumDeleteSum(s1,s2));

    }

}
