package com.whut.algorithm.high.frequence.problem287_find_the_duplicate_number;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/23 10:13
 * @desription
 */
public class FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while(true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(fast == slow)
                break;
        }
        int finder = 0;
        while(true){
            finder = nums[finder];
            slow = nums[slow];
            if(slow == finder)
                break;
        }
        return slow;

//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                map.put(num, map.get(num) + 1);
//            } else {
//                map.put(num, 1);
//            }
//        }
//
//        for (Integer key : map.keySet()) {
//            if (map.get(key) >= 2)
//                return key;
//        }
//        return 0;
    }

    public static void main(String[] args) {
        int []nums = new int[]{1,2,9,9,3};

        System.out.println(findDuplicate(nums));
    }
}
