package com.whut.interview.tencent.problem2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/22 21:15
 * @desription
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];

            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }
            System.out.println(getMax(nums));
        }
    }

    public static int getMax(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);

        int base = 1000000007;

        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];

            if (sum > base)
                sum %= base;

            for (int j = i - 1; j >= 0; j--) {

                nums[j] += nums[i];
                nums[j] %=base;
            }
        }
        return sum;
    }
}
