package com.whut.interview.alibaba.feizu.problem1;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/20 19:25
 * @desription
 */
public class Main2 {
    public static void main(String[] args) {
        int n, k;
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        k = scanner.nextInt();

        Set<Integer> set = new HashSet<>();

        //5层
        int[] result = new int[5];
        for (int i = 0; i < n; i++) {
            int a, b, c;
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();

            if (result[c - 1] < k) {
                if (!set.contains(a)) {
                    //标记a今天来过了
                    if (result[c - 1] < k) {
                        if (b == 1) {
                            ++result[c - 1];
                            set.add(a);
                        }
                    }
                } else {
                    if (b == 0) {
                        --result[c - 1];
                    }
                }
            }

            for (int j = 0; j < 5; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();

        }
    }
}
/**
 * 4 3
 * 1 1 1
 * 2 1 1
 * 1 0 1
 * 1 1 2
 * <p>
 * 5 2
 * 1 1 1
 * 2 1 1
 * 3 1 1
 * 4 1 1
 * 5 1 5
 * <p>
 * 1 0 0 0 0
 * 2 0 0 0 0
 * 2 0 0 0 0
 * 2 0 0 0 0
 * 2 0 0 0 1
 */
