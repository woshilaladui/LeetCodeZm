package com.whut.interview.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/20 17:11
 * @desription
 */
public class Main3 {

    private static int getMinTime(int n, int m, int C, int[] a) {

        //先奶茶进行排序
        Arrays.sort(a);

        //贪心解法


        return 0;
    }

    public static void main(String[] args) {
        int n, m, C;

        /**
         * 5 3 4
         * 5 8 3 10 7
         */

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        C = scanner.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();


        Arrays.sort(a);


        //计算时间和
        int allTime = 0;
        for (int i = 0; i < n; i++) {

            double temp = a[i]*1.0/C;
            allTime += Math.ceil(temp);
        }

        System.out.println((int)Math.ceil(allTime*1.0/m));
    }
}
