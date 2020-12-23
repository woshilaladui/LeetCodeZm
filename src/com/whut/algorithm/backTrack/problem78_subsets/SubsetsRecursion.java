package com.whut.algorithm.backTrack.problem78_subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/11 14:53
 * @desription
 */
public class SubsetsRecursion {
    static int[] nums = new int[]{1, 2,3};
    static List<List<Integer>> result = new ArrayList<List<Integer>>();
    static List<Integer> temp = new ArrayList<Integer>();

    public static void subsets(
            int i,
            int[] nums,
            List<Integer> temp,
            List<List<Integer>> result
    ) {


        if (i >= nums.length) {
            return;
        }

        //选择i这个结点
        temp.add(nums[i]);


        //深拷贝一下
        result.add(new ArrayList<>(temp));
        subsets(i + 1, nums, temp, result);

        //回溯
        temp.remove((Integer) nums[i]);

        subsets(i + 1, nums, temp, result);

    }

    public static void main(String[] args) {


        subsets(0, nums, temp, result);

        //System.out.println("result = " + result.size());

        for (List<Integer> list : result) {
            //System.out.println("list size = " + list.size());
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }


    }

}
