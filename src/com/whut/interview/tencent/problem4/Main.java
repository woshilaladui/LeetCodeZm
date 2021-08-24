package com.whut.interview.tencent.problem4;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/22 21:23
 * @desription
 */
public class Main {

    static int[] nums;
    static String res = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();

        nums = new int[len];

        for (int i = 0; i < len; i++) {
            nums[i] = s.charAt(i) - 'a';
        }
        getMaxString(len,k,s,0);
        System.out.println(res);
    }

    public static void getMaxString(int len, int k, String s, int begin) {
        if (len == k) {
            res += s.substring(s.length() - k);
            return;
        }

        int flag = begin;
        for (int i = begin; i <= s.length() - k; i++) {
            if (nums[i] > nums[flag]) {
                flag = i;
            }
        }

        res += s.substring(flag, flag + 1);
        getMaxString(s.length() - flag - 1, k - 1, s, flag + 1);
    }
}
