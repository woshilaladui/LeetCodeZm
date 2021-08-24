package com.whut.algorithm.interview.meituan.problem2;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/15 11:01
 * @desription
 */
public class Main2 {

    private static int f(String s) {
        int minLength = s.length() - 1;

        for (int i = s.length() - 1; i >= (s.length()-1) / 2; i--) {
            int length1 = check(s, i, i);
            int length2 = check(s, i, i + 1);
            if (length1 / 2 + i + 1 == s.length()) {
                minLength = Math.min(s.length() - length1, minLength);
            }

            if (length2 / 2 + i + 1 == s.length()) {
                minLength = Math.min(s.length() - length2, minLength);
            }
        }



        return minLength;
    }

    private static int check(String s, int left, int right) {
        while ((left >= 0 && right < s.length()) && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String str;
        Scanner scanner = new Scanner(System.in);

        str = scanner.next();

        System.out.println(f(str));

    }
}
