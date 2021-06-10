package com.whut.algorithm.high.frequence.dynamicPlaning.sub_string.problem128_longest_consecutive_sequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/8 19:06
 * @desription
 */
public class LongestConsecutiveSequence {

    private static int longestConsecutive(int[] nums) {

        if(nums.length == 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                int preLen = map.get(num - 1) == null ? 0 : map.get(num - 1);
                int lastLen = map.get(num + 1) == null ? 0 : map.get(num + 1);
                int curLen = preLen + 1 + lastLen;

                //更新自己
                map.put(num,curLen);

                max = Math.max(max, curLen);
                //更新选中两边的value值
                map.put(num - preLen, curLen);
                map.put(num + lastLen, curLen);
            }

        }

        return max;
    }

    public static void main(String[] args) {

        //100,4,200,1,3,2
        int[] nums = new  int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        System.out.println(longestConsecutive(nums));

    }

}
