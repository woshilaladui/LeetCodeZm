package com.whut.algorithm.slide_window.problem567_permutation_in_string;

import com.whut.algorithm.dynamicPlaning.test.M;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/21 18:40
 * @desription
 */
public class PermutationInString {

    private static boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        char[] c_s1 = s1.toCharArray();
        char[] c_s2 = s2.toCharArray();

        int left = 0, right = 0;

        int valid = 0;

        //初始化
        for (char c : c_s1) {
            if (need.containsKey(c))
                need.put(c, need.get(c) + 1);
            else
                need.put(c, 1);
        }

        for(char c : c_s2)
            window.put(c,0);


        //扩大窗口
        while (right < s2.length()) {

            //将要移入窗口的字符
            char c = c_s2[right];
            //扩大窗口
            right++;
            window.put(c, window.get(c) + 1);
            //对窗口数据进行更新
            if (need.containsKey(c)) {
                //将window中对应字符的个数++

                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            //对窗口进行缩小
            while (right - left >= s1.length()) {

                if (valid == need.size())
                    return true;

                //将要移除窗口的字符
                char d = c_s2[left];
                left++;

                //对窗口的数据进行更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;

                }
                window.put(d, window.get(d) - 1);
            }//end while

        }

        return false;
    }

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaaoo";

        System.out.println(checkInclusion(s1,s2));

    }
}
