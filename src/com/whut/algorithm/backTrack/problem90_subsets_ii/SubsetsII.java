package com.whut.algorithm.backTrack.problem90_subsets_ii;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/19 17:12
 * @desription
 */
public class SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();


        backTrack(nums, result, path, 0);

        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        return null;

    }

    private static void backTrack(
            int[] nums,
            List<List<Integer>> result,
            List<Integer> path,
            int index
    ) {

        result.add(new LinkedList<>(path));

        for (int i = index; i < nums.length; i++) {

            //去除重复
            if (i > index && nums[i] == nums[i - 1])
                continue;

            path.add(nums[i]);
            backTrack(nums, result, path, i + 1);
            path.remove(path.size() - 1);

        }

    }

    public static void main(String[] args) {

        subsetsWithDup(new int[]{1, 2, 2});

    }
}
