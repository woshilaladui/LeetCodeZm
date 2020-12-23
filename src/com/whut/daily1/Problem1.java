package com.whut.daily1;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/9/11 15:18
 * @desription
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/9/11 15:09
 * @desription
 */
public class Problem1 {

    /**
     *
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     *
     * @param args
     */

    public static void main(String[] args) {


        int []nums = new int[]{2,7,11,15};
        int target = 9;

        int []result;
        result = towNums(nums,target);

        for (int i : result) {
            System.out.println(i);
        }


    }


    public static int[] towNums(int[] nums, int target){

        Map<Integer,Integer> map = new HashMap<>();

        int []result = new int[2];

        for(int i=0;i<nums.length;i++){

            int diff = target - nums[i];

            if(map.containsKey(diff)){
                result[0] = map.get(diff);
                result[1] = i;
                return result;
            }

            map.put(nums[i],i);

        }

        return result;

    }

}

