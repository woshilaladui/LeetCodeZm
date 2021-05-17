package com.whut.algorithm.high_frequence.problem46_permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/26 16:26
 * @desription
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        backTrack(nums,result,path);

        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }

        return result;
    }

    public static void backTrack(int[] nums, List<List<Integer>> result, List<Integer> path) {

        //递归结束条件
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //去重
            if (path.contains(nums[i]))
                continue;

            path.add(nums[i]);

            backTrack(nums, result, path);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
}
