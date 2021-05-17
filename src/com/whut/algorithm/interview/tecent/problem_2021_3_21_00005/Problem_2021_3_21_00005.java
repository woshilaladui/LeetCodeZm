package com.whut.algorithm.interview.tecent.problem_2021_3_21_00005;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/25 14:42
 * @desription
 */
public class Problem_2021_3_21_00005 {

    public static void main(String[] args) {

        /**
         *
         * dp[i][m] = max(dp[i-1][m],)
         *
         *
         *
         */

        int t, n, m;
        Scanner scanner = new Scanner(System.in);

        t = scanner.nextInt();

        int[] dp = new int[101];

        for (int i = 0; i < 101; i++)
            dp[i] = -1;

        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();

            int sum = 0;

            int[] w = new int[n];

            for (int i = 0; i < n; i++)
                w[i] = scanner.nextInt();

            int[] dp2 = new int[101];

            if (m >= 0) System.arraycopy(dp, 0, dp2, 0, m);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dp[j] == -1)
                        continue;
                    if (dp2[(j + w[i]) % m] == -1 || dp2[(j + w[i]) % m] < dp[j] + w[i]) {
                        dp2[(j + w[i]) % m] = dp[j] + w[i];
                    }
                }

                if (m >= 0) System.arraycopy(dp2, 0, dp, 0, m);

                sum += w[i];
            }

            System.out.println(sum - dp[0]);

        }

    }
}
