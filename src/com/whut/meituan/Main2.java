package com.whut.meituan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/20 16:57
 * @desription
 */
public class Main2 {

    public static void main(String[] args) {

        /**
         * 6 8
         * 1 1 4 5 1 4
         * 3 0 4 0 3 0
         */
        int n, m;

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();

        for (int i = 0; i < n; i++)
            b[i] = scanner.nextInt();

        //对a,b进行排序
        Arrays.sort(a);
        Arrays.sort(b);

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++)
            set.add(a[i] - b[i]);

        if (set.size() == 1) {
            Object[] d = set.toArray();

            if ((int) d[0] > 0) {
                System.out.println(m - (int) d[0]);
            } else if ((int) d[0] == 0) {
                System.out.println(0);
            } else {
                System.out.println(m + (int) d[0]);
            }

        } else {
            System.out.println(-1);
        }


    }
}
