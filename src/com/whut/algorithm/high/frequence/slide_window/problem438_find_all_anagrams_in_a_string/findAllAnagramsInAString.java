package com.whut.algorithm.high.frequence.slide_window.problem438_find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/21 18:22
 * @desription
 */
public class findAllAnagramsInAString {

    private static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        char[] c_s = s.toCharArray();
        char[] c_p = p.toCharArray();


        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();


        //初始化
        for (char c : c_p) {
            if (need.containsKey(c))
                need.put(c, need.get(c) + 1);
            else
                need.put(c, 1);
            window.put(c, 0);
        }

        int left = 0, right = 0;
        //匹配上的字符的个数
        int valid = 0;

        while (right < s.length()) {

            //扩大窗口
            //将要移入窗口的字符
            char c = c_s[right];
            right++;

            //窗口内数据的更新
            if (need.containsKey(c)) {
                //window对应字符的个数++
                window.put(c, window.get(c) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            //收缩窗口
            //窗口大小于p字符串相同
            while (right - left >= p.length()) {

                //满足条件
                if(valid == need.size())
                    result.add(left);

                //将要移除的字符
                char d = c_s[left];

                //缩小窗口
                left++;

                //于上面相反的操作
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d,window.get(d)-1);
                }//end if
            }//end while

        }

        return result;

    }

    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> result = findAnagrams(s,p);

        for (Integer integer : result) {
            System.out.println(integer+" ");
        }

    }
}
