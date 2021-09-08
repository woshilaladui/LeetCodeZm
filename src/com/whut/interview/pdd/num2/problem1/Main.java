package com.whut.interview.pdd.num2.problem1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/31 19:05
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m, k, T;

        T = scanner.nextInt();

        for (int i = 0; i < T; i++) {

            int ponit = 0;

            n = scanner.nextInt();
            m = scanner.nextInt();
            k = scanner.nextInt();

            int[] red = new int[n];
            int[] blue = new int[m];

            for (int j = 0; j < n; j++) {
                red[j] = scanner.nextInt();
            }

            for (int j = 0; j < m; j++) {
                blue[j] = scanner.nextInt();
            }

            Arrays.sort(red);
            Arrays.sort(blue);

            int redP = 0;
            int blueP = 0;

            while (redP < n && blueP < m) {
                if (Math.abs(red[redP] - blue[blueP]) <= k) {
                    ponit++;
                    redP++;
                    blueP++;
                } else if (red[redP] < blue[blueP]) {
                    redP++;
                } else {
                    blueP++;
                }
            }

            System.out.println(ponit);

        }

    }

//    private static int getMaxPoint() {
//
//    }
}
