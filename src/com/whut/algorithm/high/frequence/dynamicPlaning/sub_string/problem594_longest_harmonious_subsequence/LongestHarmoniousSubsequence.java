package com.whut.algorithm.high.frequence.dynamicPlaning.sub_string.problem594_longest_harmonious_subsequence;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/8 14:47
 * @desription
 */
public class LongestHarmoniousSubsequence {

    /**
     * 不是动态规划
     * @param nums
     * @return
     */
    private static int findLHS(int[] nums) {

        //用hash来表示 思路：将数组中的元素作为key,该元素出现次数作为value存入哈希表。遍历哈希表，找出最长和谐子序列。
        int max = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }

        for (int num : nums) {
            int tempValue1 = map.get(num);
            if(map.containsKey(num+1)){
                int tempValue2 = map.get(num+1);
                max = Math.max(max,tempValue1+tempValue2);
            }
        }

        return max;
    }

    public static void main(String[] args) {

        //[1,3,2,2,5,2,3,7]
        int[] nums = new int[]{1,2,3,4};

        System.out.println(findLHS(nums));

    }

}
