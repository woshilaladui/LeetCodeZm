package com.whut.algorithm.dynamicPlaning.problem10_regular_expression_matching;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/18 15:55
 * @desription
 */
public class RegularExpressionMatching {

    private static boolean isMatch(String text, String pattern) {

        int i = 0;
        int j = 0;
        while (j < pattern.length()) {
            if (i >= text.length())
                return false;
            if (pattern.indexOf(j++) != text.indexOf(i++))
                return false;
        }

        return j == text.length();

    }

    public static void main(String[] args) {

        String text = "ab";
        String pattern = "ab";
        System.out.println(isMatch(text,pattern));
    }
}
