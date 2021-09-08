package com.whut.interview.fenghuo.problem1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/4 19:27
 * @desription
 */
public class Main {
    public static void main(String[] args) {
//        System.out.println(getMaxOneZero("1101010110010110"));
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(getMaxOneZero(str));
    }

    private static int getMaxOneZero(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        char[] arrStr = str.toCharArray();
        int max = 0;

        while (right < str.length()) {
            if (right >= 2 && arrStr[right] == '0' && arrStr[right - 1] == '1' && arrStr[right - 2] == '1') {
                left = right-1;
            }
            right++;
            max = Math.max(max,right-left);
        }

        return max;
    }
}
