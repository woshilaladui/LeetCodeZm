package com.whut.tencent;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/21 19:56
 * @desription
 */
public class Main {

    private static int getMin() {
        return 0;
    }

    public static void main(String[] args) {

        /**
         * 2
         * 3 3
         * 3 6 9
         * 3 5
         * 9 6 3
         */
        int T, n, m;

        int sum = 0;

        int tempSum = 0;

        Scanner scanner = new Scanner(System.in);

        //T = scanner.nextInt();

        T = 1;
        n = 3;
        m = 5;

        for (int i = 0; i < T; i++) {
//            n = scanner.nextInt();
//            m = scanner.nextInt();

            int[] w = new int[n];

            w[0] = 9;
            w[1] = 6;
            w[2] = 3;

            for (int j = 0; j < n; j++) {
                //w[j] = scanner.nextInt();
                sum += w[j];
            }

            //dp[i]代表最坏情况下的剩余钱

            int[] dp = new int[n + 1];

            dp[0] = sum;



        }

    }
}
