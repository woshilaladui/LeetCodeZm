package com.whut.algorithm.interview.meituan.problem1.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/15 11:24
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        int T, n;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();


        if (T < 0) {
            System.out.println("No");
        }

        for (int i = 0; i < T; i++) {
            n = scanner.nextInt();
            int[] nums = new int[n];

            for (int j = 0; j < n; j++)
                nums[j] = scanner.nextInt();
            Arrays.sort(nums);
            System.out.println(f(nums));
        }

    }

    private static String f(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] != i)
                return "No";
        }
        return "Yes";
    }
}
