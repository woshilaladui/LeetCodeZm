package com.whut.algorithm.high_frequence.problem_compress_string_lcci;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/14 19:35
 * @desription
 */
public class CompressStringIcci {

    public static String compressString(String S) {

        char[] arrayS = S.toCharArray();

        StringBuilder sb = new StringBuilder();

        int i = 0, j = 0;

        int n = S.length();

        while (j < n) {

            while (j < n && arrayS[i] == arrayS[j]) {
                j++;
            }
            sb.append(arrayS[i]).append(j - i);
            i = j;

        }

        return S.length() <= sb.toString().length() ? S : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
    }
}
