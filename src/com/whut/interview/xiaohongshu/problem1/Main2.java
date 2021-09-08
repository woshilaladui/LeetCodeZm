package com.whut.interview.xiaohongshu.problem1;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/4 10:50
 * @desription
 */
public class Main2 {
    static int[][] sum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = scanner.nextInt();
        }

        sum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i - 1][j - 1] - sum[i-1][j-1];
            }
        }
        int res = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int p = i; p <= n; p++) {
                    for (int q = j; q <= n; q++) {
                        int cur = sum[p][q] - sum[i-1][q] - sum[p][j-1] + sum[i-1][j-1];
                        res = Math.max(cur,res);
                    }
                }
            }
        }
        System.out.println(res);
    }

}
