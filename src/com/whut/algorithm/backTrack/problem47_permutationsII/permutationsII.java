package com.whut.algorithm.backTrack.problem47_permutationsII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/18 11:36
 * @desription
 */
public class permutationsII {

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);




        backtrack(result, path, visited, nums);

        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        return result;

    }

    public static void backtrack(
            List<List<Integer>> result,
            List<Integer> path,
            boolean[] visited,
            int[] nums
    ) {

        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i])
                continue;

            //去重
            /**
             * visited[i-1] 前面的重复数字已经出现过
             *
             * 151  ->151   两个1要判断前面那个1是否出现过
             *
             */
            if (i > 0 && nums[i] == nums[i - 1] && visited[i-1])
                continue;

            path.add(nums[i]);
            visited[i] = true;
            backtrack(result, path, visited, nums);
            path.remove(path.size() - 1);
            visited[i] = false;

        }

    }


    public static void main(String[] args) {

        int[] nums = new int[]{1,1,2};

        permuteUnique(nums);

    }
}
