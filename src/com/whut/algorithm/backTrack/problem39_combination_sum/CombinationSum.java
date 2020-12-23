package com.whut.algorithm.backTrack.problem39_combination_sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/1 14:23
 * @desription
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, result, path, 0);
        return result;
    }

    private  void backTrack(
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

    }
}
