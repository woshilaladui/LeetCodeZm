package com.whut.algorithm.slide_window.problem76_minimum_window_substring;

import com.whut.algorithm.dynamicPlaning.test.M;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/21 15:41
 * @desription
 */
public class MinimumWindowSubstring {

    private static String minWindow(String s, String t) {

        if (s.equals(t))
            return t;

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        char[] c_t = t.toCharArray();
        char[] c_s = s.toCharArray();

        //匹配的个数
        int vaild = 0;

        //初始化need
        for (char c : c_t) {
            if (need.containsKey(c))
                need.put(c, need.get(c) + 1);
            else
                need.put(c, 1);

            window.put(c, 0);
        }

        int start = 0, len = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < s.length()) {
            //c是将移入窗口的字符
            char c = c_s[right];
            right++;

            //如果包含t中的字符，则window对应位置要增加
            if (need.containsKey(c)) {
                window.put(c, window.get(c) + 1);

                if (need.get(c).equals(window.get(c))) {
                    vaild++;
                }
            }

            //判断是否要收缩滑动窗口
            while (vaild == need.size()) {
                //在这里更新最小覆盖串
                if ((right - left) < len) {
                    start = left;
                    len = right - left;
                }

                //d是要移除窗口的字符串
                char d = c_s[left];

                //左移窗口
                left++;

                //对滑动窗口数据进行更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        vaild--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }


        }//end while

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {

        String s = "bbaa";
        String t = "aba";

        System.out.println(minWindow(s, t));

    }
}
