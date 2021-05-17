package com.whut.algorithm.high_frequence.problem3_longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/15 19:23
 * @desription
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> window = new HashMap<>();

        char[] arrayS = s.toCharArray();

        //初始化
        for (char c : arrayS) {
            window.put(c, 0);
        }

        int left = 0, right = 0;

        int result = 0;

        while (right < s.length()) {
            //移入窗口
            char c = arrayS[right];

            //窗口右移
            right++;
            //对窗口数据进行更新
            window.put(c, window.get(c) + 1);

            //判断窗口是否需要收缩
            while (window.get(c) > 1) {
                //说明有重复
                char d = arrayS[left];
                //缩小窗口
                left++;
                window.put(d, window.get(d) - 1);
            }

            result = Math.max(result, right - left);

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
