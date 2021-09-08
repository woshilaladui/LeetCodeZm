package com.whut.interview.xiaomi.problem1;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/8 19:31
 * @desription
 */
public class Main {
    /**
     * 1A2C3D4E56
     * A1B2345C6D
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int len1 = str1.length();
        int len2 = str2.length();
        char[] arrStr1 = str1.toCharArray();
        char[] arrStr2 = str2.toCharArray();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (arrStr1[i - 1] == arrStr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }//end for
        System.out.println(dp[len1][len2]);
    }
}
