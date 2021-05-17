package com.whut.algorithm.high_frequence.problem647_palindromic_substrings;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/23 10:58
 * @desription
 */
public class PalindromicSubstrings {

    private static int count = 0;

    public int countSubstrings(String s) {
        return 0;
    }

    private static boolean isPalindromic(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    private static void backTrack(String s, List<String> result, String path, int start) {

        if (isPalindromic(path))
            result.add(path);

        if (start == s.length())
            return;


        for (int i = start; i < s.length(); i++) {



        }


    }

    public static void main(String[] args) {

    }
}
