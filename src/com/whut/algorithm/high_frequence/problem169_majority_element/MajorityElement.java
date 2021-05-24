package com.whut.algorithm.high_frequence.problem169_majority_element;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/24 10:41
 * @desription
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        int result = 0;
        int maxCount = 0;

        for (Map.Entry entry : map.entrySet()) {
            if((int)entry.getValue() > maxCount){
                maxCount = (int)entry.getValue();
                result = (int)entry.getKey();
            }

        }

        return result;
    }

    public static void main(String[] args) {

        Map<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);

        int[] nums = new int[]{3, 2,3};
        System.out.println(majorityElement(nums));
    }
}
