package com.whut.algorithm.high.frequence.problem344_reverse_string;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/14 12:05
 * @desription
 */
public class ReverseString {

    public static void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;

        }

    }

    public static void main(String[] args) {
        reverseString("abcdefg".toCharArray());
    }
}
