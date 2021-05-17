package com.whut.alibaba;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/19 19:34
 * @desription
 */
public class Test1 {

    private static int findMin(int a) {

        double c = Math.sqrt(a);

        int b = (int) c;

        if (b == c)
            return 0;
        else
            return Math.min(a - b * b, (b + 1) * (b + 1) - a);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        /**
         * 思路:
         *
         * 快速排序后
         * 每个数字变成平方最小的消费去
         *
         * 快速查找，选取第length/2个位置
         *
         */

        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = findMin(a[i][0]);
        }

        //升序排序
        Arrays.sort(a,(b,c)->b[1]-c[1]);

        int result = 0;

        for (int i = 0; i < (a.length +1)/ 2; i++) {
            result += a[i][1];
        }

        System.out.println(result);
    }
}
