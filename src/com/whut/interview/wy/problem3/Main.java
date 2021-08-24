package com.whut.interview.wy.problem3;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/21 16:01
 * @desription
 */
public class Main {


    public static int[] getMin(int[] ages) {

        int[] arr = new int[ages.length];

        arr[0] = 1;

        int n = ages.length;

        for (int i = 1; i < n; i++) {
            if (ages[i] > ages[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            } else if (ages[i] == ages[i - 1]) {
                //重置
                arr[i] = 1;
            } else {
//                int flag = 1, tmp = i;
//                while (tmp + 1 < n && ages[tmp] > ages[tmp + 1]) {
//                    tmp++;
//                    flag++;
//                }
//
//                i = tmp;
//                arr[tmp] = 1;
//                while (flag > 0) {
//                    arr[tmp - 1] = arr[tmp] + 1;
//                    tmp--;
//                    flag--;
//                }
                arr[i] = 1;
                if (arr[i - 1] == 1) {
                    int tmp = i - 1;
                    while (tmp >= 0 && ages[tmp] > ages[tmp + 1]) {
                        arr[tmp] = Math.max(arr[tmp], arr[tmp + 1] + 1);
                        tmp--;
                    }
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        String[] strs = str.split(" ");

        int[] ages = new int[strs.length];

        for (int i = 0; i < strs.length; i++)
            ages[i] = Integer.parseInt(strs[i]);

        int[] arr = getMin(ages);

        int result = 0;
        for (int i = 0; i < ages.length; i++)
            result += arr[i];

        System.out.println(result);
    }
}
