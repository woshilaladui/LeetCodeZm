package com.whut.interview.tencent.problem2;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/22 20:28
 * @desription
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];

            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }
            int max = getMax(nums);
            System.out.println(max);
        }
    }

    public static int getMax(int[] nums) {
        int max = 0;
        int len = nums.length - 1;
        Arrays.sort(nums);
        int base = 1000000007;

        for (int i = len - 1; i >= 0; i--) {
            max = max + nums[i] * (1 << i);
//            int temp = nums[i] * (1 << i);
//            if (temp > base)
//                temp %= base;
//
//            max = max + temp;
//
//            if (max > base)
//                max %= base;
        }
        return max;
    }
}
