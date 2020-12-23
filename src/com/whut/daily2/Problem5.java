package com.whut.daily2;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/9/14 19:50
 * @desription
 */
public class Problem5 {

    public static void main(String[] args) {


        String s = "babad";

        System.out.println(longestPalindrome(s));

    }

    /**
     * 动态规划转移方程
     *
     * 如果在一个不是回文字符串的字符串两端添加任何字符，或者在回文串左右分别加不同的字符，得到的一定不是回文串
     * 如果一个字符串不是回文串，或者在回文串左右分别加不同的字符，得到的一定不是回文串
     *
     * if (s[i] === s[j] && dp[i + 1][j - 1]) {
     *   dp[i][j] = true;
     * }
     */

    public static String longestPalindrome(String s){


        if(s == null || s.length() == 0)
            return "";


        String result = s.charAt(0)+"";

        boolean [][]dp = new boolean[1000][1000];

        for(int i=s.length()-1;i>=0;i--){

            for(int j=i;j<s.length();j++){

                if(i ==j)
                    dp[i][j] = true;

                else if(j-i == 1 && s.charAt(i) == s.charAt(j))
                    dp[i][j] = true;
                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1])
                    dp[i][j] = true;

                if (dp[i][j] && j - i + 1 > result.length()) {
                    // update res
                    result = s.substring(i, j + 1);
                }
            }//end for
        }//end for

        return result;

    }


}
