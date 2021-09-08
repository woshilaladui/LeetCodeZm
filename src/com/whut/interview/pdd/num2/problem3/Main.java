package com.whut.interview.pdd.num2.problem3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/31 19:36
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        Map<Long, Long> map = new HashMap<>();

        for (int i = 0; i < t; i++) {

            long l = scanner.nextLong();
            if (map.get(l) != null) {
                System.out.println(map.get(l));
            } else {
                long maxNum = getMaxNum(l);
                map.put(l, maxNum);
                System.out.println(maxNum);
            }
        }
    }

    private static long getMaxNum(long n) {
        long temp = 0;
//        for (long i = 0; i < n; i++) {
//            if (2 * i * (i + 1) >= n) {
//                temp = i - 1;
//                break;
//            }
//        }//end for

        temp = (long) ((Math.sqrt(2 * n + 1) - 1) / 2);

        long num = 2 * temp * (temp + 1);
        if (n < num + 3) {
            return temp * temp;
        } else if (n <= num + 2 * temp + 1) {
            long i = (num + 2 * temp + 1) - n;
            long j = i / 2;
            long k = i % 2;
            return k == 0 ? temp * (temp + 1) - j : temp * (temp + 1) - j - 1;
        } else if (n < num + 2 * temp + 4) {
            return temp * (temp + 1);
        } else {
            long i = 2 * (temp + 1) * (temp + 2) - n;
            long j = i / 2;
            long k = i % 2;
            return k == 0 ? (temp + 1) * (temp + 1) - j : (temp + 1) * (temp + 1) - j - 1;
        }

    }
}
