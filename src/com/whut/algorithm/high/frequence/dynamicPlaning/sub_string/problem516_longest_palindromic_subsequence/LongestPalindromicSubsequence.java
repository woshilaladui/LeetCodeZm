package com.whut.algorithm.high.frequence.dynamicPlaning.sub_string.problem516_longest_palindromic_subsequence;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/6 15:46
 * @desription
 */
public class LongestPalindromicSubsequence {


    private static int  longestPalindromeSubseq(String s) {

        //dp[i][j]  代表s[i...j]之间能够组成的最大回文序列

        int n = s.length();

        char[] str = s.toCharArray();

        int[][] dp = new int[n][n];
        //i = j时候说明只有一个字符，就是回文串 返回1
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;

        /**
         *
         * dp[i][j] 于dp[i+1][j-1] dp[i+1][j] dp[i][j-1]
         *
         *
         * dp[i][j-1]    dp[i][j]
         * dp[i+1][j-1] dp[i+1][j]
         *
         *
         * 选择从下往上遍历
         *
         * 反着遍历，详情见md文件解析
         *
         */
        int max = 0;
        int ii = 0;
        int jj = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {

                if (str[i] == str[j]){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if(dp[i][j] > max){
                        ii = i;
                        jj = j;
                        max = dp[i][j];
                    }
                }

                else{
                    dp[i][j] = Math.max(
                            dp[i][j - 1],
                            dp[i + 1][j]
                    );
                    if(dp[i][j] > max){
                        ii = i;
                        jj = j;
                        max = dp[i][j];
                    }
                }


            }


        }

        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }

        System.out.println(ii);
        System.out.println(jj);

        System.out.println(s.substring(ii,jj+1));
        return dp[0][n-1];
    }

    public static void main(String[] args) {

        String s = "aacabdkacaa";

        System.out.println("changdu = " + longestPalindromeSubseq(s));

    }

}
