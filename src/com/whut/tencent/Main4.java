package com.whut.tencent;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/21 20:52
 * @desription
 */
public class Main4 {

    public static void main(String[] args) {

        int n, m;

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        int[] x = new int[n];

        int[] y = new int[n];


        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {

            for (int j = n - 1; j > i; j--) {
                if (y[j - 1] > y[j]) {

                    int temp = y[j - 1];
                    y[j - 1] = y[j];
                    y[j] = temp;

                    temp = x[j - 1];
                    x[j - 1] = x[j];
                    x[j] = temp;
                }
            }

        }
        int zn = n / 2;
        //如果是奇数
        if (n % 2 != 0) {


            int sum = 0;

            for (int i = 0; i < n; i++) {
                if (i == zn)
                    continue;
                sum += x[i];
            }

            if (m - sum >= y[zn])
                System.out.println(y[zn]);
            else
                System.out.println(m - sum);
        } else {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                if (i == zn || i == zn-1)
                    continue;
                sum += x[i];
            }

            if (m - sum >= y[zn] + y[zn-1])
                System.out.println((y[zn] + y[zn-1])/2);
            else {

            }
        }
    }
}
