package com.whut.algorithm.backTrack.problem377_combination_sum_iv;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/1 17:03
 * @desription
 */
public class CombinationSumIv {

    //当时数据量大的话会超时
    public static int combinationSum4(int[] nums, int target) {

        List<Integer> path = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        backTrack(nums,target,result,path);

//        for (List<Integer> list : result) {
//            for (Integer integer : list) {
//                System.out.print(integer+" ");
//            }
//            System.out.println();
//        }

        return result.size();
    }

    private static void backTrack(
            int[] nums,
            int target,
            List<List<Integer>> result,
            List<Integer> path
    ) {

        if (target == 0) {
            result.add(new LinkedList<>(path));
            return;
        }

        if (target < 0)
            return;

        for(int i=0;i<nums.length;i++){

            path.add(nums[i]);
            backTrack(nums,target-nums[i],result,path);
            path.remove(path.size()-1);

        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{4,2,1};
        int target = 25;
        System.out.println(combinationSum4(nums,target));

    }
}
