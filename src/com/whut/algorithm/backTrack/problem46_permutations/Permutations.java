package com.whut.algorithm.backTrack.problem46_permutations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/18 10:17
 * @desription
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        backTrack(nums, result, path);
        return result;

    }

    private static void backTrack(
            int[] nums,
            List<List<Integer>> result,
            List<Integer> path
    ) {
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }

        //区别其他回溯为什么i=index,因为这个题目确定拿3位置，需要重头扫描
        for (int i = 0; i < nums.length; i++) {

            if(path.contains((Integer)nums[i]))
                continue;

//            if(path.size()>0&&i < path.size()&&path.get(i) != null)
//                continue;

            path.add(nums[i]);
            backTrack(nums, result, path);
            path.remove(path.size() - 1);

        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};

        List<List<Integer>> result = permute(nums);

        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();

        }
    }

}
