package com.whut.interview.pdd.problem2.problem2;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/8 20:08
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int c = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        int count = 0;

        if (c > n) {
            System.out.println(0);
        } else {
            int left = 0;
            int right = 0;
            while (right < arr.length) {
                if (arr[right] > t) {
                    left = right + 1;
                } else {
                    if (right - left + 1 >= c) {
                        count++;
                        left++;
                    }
                }
                right++;
            }
        }
        System.out.println(count);
    }
}
