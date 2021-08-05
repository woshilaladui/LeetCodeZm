package com.whut.algorithm.high.frequence.common.problem557_reverse_words_in_a_string_iii;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/11 13:37
 * @desription
 */
public class ReverseWordsInAStringIII {
    public static String reverseWords(String s) {

        String[] strs = s.split(" ");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < strs.length - 1; i++) {
            StringBuilder sb = new StringBuilder(strs[i]);

            result.append(sb.reverse().toString()).append(" ");
        }

        result.append(new StringBuilder(strs[strs.length - 1]).reverse());

        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}


