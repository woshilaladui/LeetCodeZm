package com.whut.algorithm.high.frequence.problem125_valid_palindrome;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/25 15:53
 * @desription
 */
public class ValidPalindrome {

    private static boolean isLetterOrNumber(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }

    public static boolean isPalindrome(String s) {


        String str = s.replace(" ", "");

        str = str.toLowerCase();

        char[] c_s = str.toCharArray();

        int n = c_s.length;


        int left = 0, right = c_s.length - 1;

        while (left < right) {

            while (left < n && !isLetterOrNumber(c_s[left]))
                left++;

            if (left >= right)
                return true;

            while (right >= 0 && !isLetterOrNumber(c_s[right]))
                right--;

            if (left >= right)
                return true;
//
//            if(!isLetterOrNumber(c_s[left]))
//                left++;
//
//            if(!isLetterOrNumber(c_s[right]))
//                right--;

            if (c_s[left] == c_s[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
}
