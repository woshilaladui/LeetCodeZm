package com.whut.algorithm.high.frequence.backTrack.problem40_combination_sum_ii;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/19 16:15
 * @desription
 */
public class CombinationSumII {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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

            if (i != index && candidates[i] == candidates[i - 1])
                continue;

            path.add(candidates[i]);
            backTrack(candidates, target - candidates[i], result, path, i + 1);
            path.remove(path.size() - 1);

        }

    }

    public static void main(String[] args) {


    }
}
