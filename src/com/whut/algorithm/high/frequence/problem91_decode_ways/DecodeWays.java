package com.whut.algorithm.high.frequence.problem91_decode_ways;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/31 20:45
 * @desription
 */
public class DecodeWays {


    public static int numDecodings(String s) {

        int n = s.length();

        //代表以i位置结尾可以构成的总数
        int[] dp = new int[n];

        if(s.charAt(0) == '0')
            return 0;

        dp[0] = 1;

        char[] charArray = s.toCharArray();

        for (int i = 1; i < n; i++) {
            //本身这一位
            if (charArray[i] != '0')
                dp[i] += dp[i - 1];

            //与前面组合
            if (charArray[i-1] == '1' || charArray[i - 1] == '2' && charArray[i] <= '6') {
                if (i - 2 >= 0) {
                    dp[i] += dp[i - 2];
                } else
                    dp[i]++;
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }
}
