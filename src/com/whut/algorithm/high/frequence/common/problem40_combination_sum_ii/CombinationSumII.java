package com.whut.algorithm.high.frequence.common.problem40_combination_sum_ii;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/6 8:42
 * @desription
 */
public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        Set<Integer> set = new HashSet<>();
        backTrack(candidates, target, result, path, 0);

        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }

        return result;
    }

    private  static void backTrack(
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

        Set<Integer> set = new HashSet<>();

        for (int i = index; i < candidates.length; i++) {

            if (candidates[i] > target)
                break;

            if(set.contains(candidates[i]))
                continue;

//            if (i != index && candidates[i] == candidates[i - 1])
//                continue;
            set.add(candidates[i]);
            path.add(candidates[i]);
            backTrack(candidates, target - candidates[i], result, path, i + 1);
            path.remove(path.size() - 1);

        }

    }

    public static void main(String[] args) {
        combinationSum2(new int[]{10,1,2,7,6,1,5},8);
    }
}
