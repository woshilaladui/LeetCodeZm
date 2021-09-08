package com.whut.interview.douyu.problem2;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/29 20:40
 * @desription
 */
public class Main2 {

    public static String LCB(String str1, String str2) {

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int result = 0;

        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length;j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

                if (result < dp[i][j])
                    result = dp[i][j];
            }
        }


        System.out.println(result);

        if (result == 0)
            return "-1";

        StringBuilder sb = new StringBuilder();

        for (int i = arr1.length; i >= 1; i--) {
            for (int j = arr2.length; j >= 1; j--) {
                if (dp[i][j] == result && arr1[i-1] == arr2[j-1]) {
                    sb.append(arr1[i - 1]);
                    result--;
                    //后移一位
                    //i--;
                }
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(LCB("1A2C3D4B56", "B1D23A456A"));
    }
}
