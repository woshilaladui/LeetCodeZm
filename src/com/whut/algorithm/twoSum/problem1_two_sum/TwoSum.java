package com.whut.algorithm.twoSum.problem1_two_sum;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/2 16:02
 * @desription
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++)
            map.put(nums[i], i);

        for (int i = 0; i < n; i++) {
            int other = target - nums[i];

            //other存在，且不等于Nums[i]自身
            if(map.containsKey(other) && map.get(other) != i)
                return new int[]{i,map.get(other)};
        }

        return new int[]{-1,-1};

    }


    public static void main(String[] args) {



    }

}
