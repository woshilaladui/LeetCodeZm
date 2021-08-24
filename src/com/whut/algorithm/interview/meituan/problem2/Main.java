package com.whut.algorithm.interview.meituan.problem2;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/15 10:37
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        char[] arrayStr = str.toCharArray();

        int n = arrayStr.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arrayStr[i] != arrayStr[j]) {
                    if(i ==0){
                        //dp[0][i] =
                    }
                    dp[i][j] = Math.min(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    ) + 1;
                }
            }
        }


        System.out.println(dp[0][n - 1]);
    }
}
