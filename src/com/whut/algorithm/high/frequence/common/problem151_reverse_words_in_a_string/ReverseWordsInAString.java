package com.whut.algorithm.high.frequence.common.problem151_reverse_words_in_a_string;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/20 12:29
 * @desription
 */
public class ReverseWordsInAString {

    public static String reverseWords(String s) {

        s = s.trim();

        String[] values = s.split(" ");

        StringBuilder sb = new StringBuilder();

        int n = values.length;

        if (n == 1) {
            sb.append(values[n - 1]);
            return sb.toString();
        } else {
            sb.append(values[n - 1]).append(" ");
        }


        for (int i = n - 2; i >= 0; i--) {
            if (i == 0)
                sb.append(values[0]);
            else if (!values[i].equals(""))
                sb.append(values[i]).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
}
