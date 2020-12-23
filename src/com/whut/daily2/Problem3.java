package com.whut.daily2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/9/14 15:15
 * @desription
 */
public class Problem3 {



    public static void main(String[] args) {


        String s = "abba";


        System.out.println("result = " + lengthOfLongestSubstring(s));

    }

    /**
     *
     *
     1. 用一个 mapper 记录出现过并且没有被删除的字符

     2. 用一个滑动窗口记录当前 index 开始的最大的不重复的字符序列

     3. 用 res 去记录目前位置最大的长度，每次滑动窗口更新就去决定是否需要更新 res
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) {
            return s.length();
        }
        int result=0;
        //通过哈希表来快速定位重复字符的最新位置
        Map<Character,Integer> map = new HashMap<>();

        //用快慢指针，快指针指向最新的下标，慢指针指向不重复的最小下标
        int fast =0;
        int slow =0;
        while(fast<s.length()) {
            if(map.containsKey(s.charAt(fast))) {
                //获取当前最大的下标
                /**
                 *
                 * eg:
                 *    pwwwkew
                 *    abba
                 */
                slow = Math.max(slow, map.get(s.charAt(fast))+1);
            }
            //重设mapper
            map.put(s.charAt(fast), fast);
            result = Math.max(result, fast-slow+1);
            //更新快指针
            fast++;
        }

        return result;
    }

}
