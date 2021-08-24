package com.whut.algorithm.interview.meituan.problem1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/15 10:07
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        int T, n;
        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();
        n = scanner.nextInt();
        Set<Integer> set = null;


        for (int j = 0; j < T; j++) {
            boolean flag = false;
            int[] nums = new int[n];
            set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
                set.add(nums[i]);
            }


            for (int i = 1; i <= n; i++) {
                if (!flag && !set.contains(i)) {
                    System.out.println("No");
                    flag = true;
                }
            }

            if(!flag)
                System.out.println("Yes");
        }



    }
}
