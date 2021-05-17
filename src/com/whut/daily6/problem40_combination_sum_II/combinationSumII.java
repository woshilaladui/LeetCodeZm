package com.whut.daily6.problem40_combination_sum_II;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/17 19:43
 * @desription
 */
public class combinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();

        subsetsRecursion(0, candidates, temp, result, 0, target);

        //去重
        Set<List<Integer>> set = new HashSet<>(result);

        return new ArrayList<>(set);

    }


    public static void subsetsRecursion(
            int i,
            int[] nums,
            List<Integer> temp,
            List<List<Integer>> result,
            int sum,
            int target
    ) {

        if (sum > target || i >= nums.length) {
            return;
        }

        temp.add(nums[i]);
        sum += nums[i];
        if (sum == target) {
            Collections.sort(temp);
            result.add(new ArrayList<>(temp));
        }
        subsetsRecursion(i + 1, nums, temp, result, sum, target);
        temp.remove((Integer) nums[i]);
        sum -= nums[i];
        subsetsRecursion(i + 1, nums, temp, result, sum, target);

    }

//    public static LinkedList<LinkedList<Integer>> combinationSum3(int[] candidates, int target) {
//        LinkedList<LinkedList<Integer>> res = new LinkedList<>();
//        LinkedList<Integer> path = new LinkedList<>();
//        Arrays.sort(candidates);
//        backTrack(target, candidates, res, path,  0);
//        return res;
//    }
//
//    private static void backTrack(int target, int[] candidates,  LinkedList<LinkedList<Integer>> res,
//                           LinkedList<Integer> path, int index) {
//        if (target == 0) {
//            res.add(new LinkedList(path));
//            return;
//        }
//        if (target < 0) {
//            return;
//        }
//        for (int i=index; i<candidates.length; i++) {
//            if (candidates[i] > target) break;
//            if (i != index && candidates[i] == candidates[i-1]) {
//                continue;
//            }
//
//            path.add(candidates[i]);
//            backTrack(target-candidates[i], candidates, res, path, i+1);
//            path.remove(path.size()-1);
//
//        }
//    }


    public static List<List<Integer>> combinationSum3(int[] candidates, int target) {

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, result, path, 0);
        return result;
    }

    /**
     *
     * @param candidates
     * @param target
     * @param result
     * @param path
     * @param index 从哪个位置开始
     */
    private static void backTrack(
            int[] candidates,
            int target,
            List<List<Integer>> result,
            List<Integer> path,
            int index
    ) {
        if (target == 0) {
            result.add(new LinkedList<>(path));
            return;
        }
        if (target < 0)
            return;

        for (int i = index; i < candidates.length; i++) {

            if (candidates[i] > target)
                break;

            //去重复
//            if (i != index && candidates[i] == candidates[i - 1])
//                continue;

            path.add(candidates[i]);

            //backTrack(candidates, target - candidates[i], result, path, i + 1);
            backTrack(candidates, target - candidates[i], result, path, i );
            path.remove(path.size() - 1);

        }

    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;

        List<List<Integer>> result = combinationSum3(candidates, target);

        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }

    }

}
