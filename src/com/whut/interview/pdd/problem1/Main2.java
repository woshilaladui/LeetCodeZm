package com.whut.interview.pdd.problem1;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/8 19:58
 * @desription
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int[] nums = new int[3];
            for (int j = 0; j < 3; j++)
                nums[j] = scanner.nextInt();
            System.out.println(getNum(nums));
        }
    }

    private int[] getNumber(int[][] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < result.length; i++) {
            int num = getNum(nums[i]);
            result[i] = num;
        }
        return result;
    }


    public static int getNum(int[] nums) {
        int result = 0;
        int x = nums[0], y = nums[1], r = nums[2];

        double zeroLength = Math.sqrt(x * x + y * y);

        if (r > zeroLength) {
            return 4;
        } else if (r == zeroLength) {
            if (x == 0 || y == 0)
                return 2;
            return 3;
        } else {
            if (r > Math.abs(x)) {
                result += 2;
            } else if (r == Math.abs(x)) {
                result++;
            }

            if (r > Math.abs(y))
                result += 2;
            else if (r == Math.abs(y))
                result++;

            return result;
        }

    }


}
