package com.whut.algorithm.high.frequence.problem217_contains_duplicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/19 20:51
 * @desription
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {

            if(list.contains(num)){
                return true;
            }else {
                list.add(num);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int []nums = new int[]{1,2,3,4};

        System.out.println(containsDuplicate(nums));
    }
}
