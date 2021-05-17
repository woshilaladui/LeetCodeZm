package com.whut.algorithm.high_frequence.slide_window.problem567_permutation_in_string;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/15 20:00
 * @desription
 */
public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {

        char[] arrayS1 = s1.toCharArray();
        char[] arrayS2 = s2.toCharArray();

        int len1 = s1.length();
        int len2 = s2.length();

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        int valid = 0;

        //初始化
        for (char c : arrayS1) {
            if (!need.containsKey(c)) {
                need.put(c, 1);
            } else {
                need.put(c, need.get(c) + 1);
            }
        }

        for (char c : arrayS2) {
            window.put(c, 0);
        }

        int left = 0, right = 0;

        while (right < len2) {
            //移入窗口的字符
            char c = arrayS2[right];
            right++;

            //对窗口做更新
            window.put(c, window.get(c) + 1);

            if (need.containsKey(c)) {
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            //判断窗口是不是需要收缩
            while (right - left >= len1) {
                //要移除窗口的元素
                char d = arrayS2[left];

                if (valid == need.size())
                    return true;


                left++;
                //对窗口数据进行更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                }

                window.put(d, window.get(d) - 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        /**
         * "abcdxabcde"
         * "abcdeabcdx"
         */
        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";

        Deque<String> queue = new ArrayDeque<>();

        queue.add("abc");
        queue.add("456");
        queue.add("789");

        System.out.println(String.join(".",queue));


        System.out.println(checkInclusion(s1,s2));
    }
}
