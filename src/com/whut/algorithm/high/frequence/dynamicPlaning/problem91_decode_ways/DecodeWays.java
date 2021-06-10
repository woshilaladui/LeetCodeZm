package com.whut.algorithm.high.frequence.dynamicPlaning.problem91_decode_ways;

import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/24 18:51
 * @desription
 */
public class DecodeWays {

    public static int numDecodings(String s) {


        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];

        Arrays.fill(dp, 0);

        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i < s.length() + 1; i++) {
            String one = s.substring(i - 1, i);
            String two = s.substring(i - 2, i);
            System.out.println("one = " + one);
            System.out.println("two = " + two);
            int intOne = Integer.parseInt(one);
            int intTwo = Integer.parseInt(two);

            if (intTwo >= 10 && intOne <= 26)
                dp[i] = dp[i - 2];

            if (intOne >= 1 && intOne <= 9)
                dp[i] += dp[i - 1];
        }

        return dp[dp.length - 1];

//  const dp = Array(s.length + 1).fill(0);
//        dp[0] = 1;
//        dp[1] = s[0] !== "0" ? 1 : 0;
//        for (let i = 2; i < s.length + 1; i++) {
//    const one = +s.slice(i - 1, i);
//    const two = +s.slice(i - 2, i);
//
//            if (two >= 10 && two <= 26) {
//                dp[i] = dp[i - 2];
//            }
//
//            if (one >= 1 && one <= 9) {
//                dp[i] += dp[i - 1];
//            }
//        }
//
//        return dp[dp.length - 1];

        //return 0;

    }

    public static int numDecodings2(String s) {
        int n = s.length();
        int[] dp = new int[n];

        if (s.charAt(0) == '0')
            return 0;

        dp[0] = 1;

        for (int i = 1; i < n; i++) {

            //本身一位
            if (s.charAt(i) != '0')
                dp[i] += dp[i - 1];

            //考虑本身位置和前一位是否能组成解码
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                if (i - 2 >= 0)
                    dp[i] += dp[i - 2];
                else
                    dp[i]++;

            }

        }

        return dp[n - 1];

    }

    public static void main(String[] args) {


        System.out.println(numDecodings2("226"));

    }

}
