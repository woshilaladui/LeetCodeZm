package com.whut.algorithm.high_frequence.divide_and_conquer.problem395_longest_substring_with_at_least_k_repeating_characters;

import com.whut.algorithm.dynamicPlaning.test.M;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/26 12:14
 * @desription
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        return longestSubstring(s, k, 0, s.length() - 1);
    }

    public int longestSubstring(String s, int k, int low, int high) {

        char[] arrayS = s.toCharArray();

        /**
         * 终止条件
         *
         * 区间长度小于k，不存在结果
         */
        if (high - low + 1 < k)
            return 0;

        //统计区间的字符出现频次
        Map<Character, Integer> map = new HashMap<>();

        for (int i = low; i <= high; i++) {
            char ch = arrayS[i];
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else
                map.put(ch, 1);
        }


        //在区间长度>=k的前提下，如果low位置上的字符出现的次数小于k
        while (high - low + 1 >= k && map.get(arrayS[low]) < k)
            low++;

        //在区间长度>=k的前提下，如果low位置上的字符出现的次数小于k
        //int temp = map.get(arrayS[high]);
        //System.out.println(temp);
        while (high - low + 1 >= k && map.get(arrayS[high]) < k)
            high--;

        //再次判断区间长度是否满足要求，因为low,high发生了改变
        if (high - low + 1 < k)
            return 0;

        //遍历当前区间
        for (int i = low; i <= high; i++) {
            // 如果在区间内的出现次数 < k，递归考察两侧的区间
            if (map.get(arrayS[i]) < k) {
                return Math.max(
                        longestSubstring(s, k, low, i - 1),
                        longestSubstring(s, k, i + 1, high)
                );
            }
        }
        // 当前区间的字符出现次数都 >= k，当前区间满足要求，返回该长度
        return high - low + 1;

    }

    public static void main(String[] args) {
        LongestSubstringWithAtLeastKRepeatingCharacters longestSubstringWithAtLeastKRepeatingCharacters = new LongestSubstringWithAtLeastKRepeatingCharacters();


        /**
         * "aabcabb"
         * 3
         */
        System.out.println(longestSubstringWithAtLeastKRepeatingCharacters.longestSubstring("aabcabb", 3));
    }
}
