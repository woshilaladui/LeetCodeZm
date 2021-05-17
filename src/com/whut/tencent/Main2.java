package com.whut.tencent;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/21 21:04
 * @desription
 */
public class Main2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T;
        int n;

        T = scanner.nextInt();


        for (int i = 0; i < T; i++) {
            n = scanner.nextInt();

            if (n == 1) {
                System.out.println(1);
            } else if (n == 2) {
                System.out.println(2);
            } else if (n == 3) {
                System.out.println(2);
            } else {
                int[] dp = new int[n + 1];

                dp[0] = 1;
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 2;

                for (int j = 4; j <= n; j++) {
                    dp[j] = dp[j - 1] + 1;

                    if (j % 2 == 0) {
                        dp[j] = Math.min(dp[j / 2] + 1, dp[j]);
                    }

                    if (j % 3 == 0) {
                        dp[j] = Math.min(dp[j / 3] + 1, dp[j]);
                    }

                }
                System.out.println(dp[n]);
            }
        }
    }
}
