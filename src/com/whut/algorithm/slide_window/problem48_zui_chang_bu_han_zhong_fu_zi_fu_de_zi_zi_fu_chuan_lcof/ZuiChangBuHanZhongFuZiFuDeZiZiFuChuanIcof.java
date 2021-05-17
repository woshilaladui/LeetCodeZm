package com.whut.algorithm.slide_window.problem48_zui_chang_bu_han_zhong_fu_zi_fu_de_zi_zi_fu_chuan_lcof;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/21 16:55
 * @desription
 */
public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanIcof {

    private static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> window = new HashMap<>();

        char[] c_s = s.toCharArray();

        int left = 0, right = 0;

        int res = 0;

        //初始化
        for (char c : c_s)
            window.put(c, 0);

        while (right < s.length()) {

            //将要移入窗口的字符
            char c = c_s[right];
            //窗口右移
            right++;
            window.put(c, window.get(c) + 1);

            //判断窗口是否要收缩
            //说明有重复的，直接缩小窗口即可
            while (window.get(c) > 1) {
                char d = c_s[left];
                left++;
                window.put(d, window.get(d) - 1);
            }

            //先是left++ 了所以长度len = right - left;
            res = Math.max(res, right - left);

        }

        return res;
    }

    public static void main(String[] args) {


        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));

    }
}
