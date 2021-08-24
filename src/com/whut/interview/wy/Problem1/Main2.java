package com.whut.interview.wy.Problem1;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/21 15:42
 * @desription
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        int M = scanner.nextInt();

        String[] strs = str.split(" ");


        int[] nums = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {

            nums[i] = Integer.parseInt(strs[i]);
        }

        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] <= M)
                    result++;
            }
        }

        System.out.println(result);
    }
}
