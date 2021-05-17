package com.whut.algorithm.high_frequence.problem39_combination_sum;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/6 8:29
 * @desription
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new LinkedList<>();

        List<Integer> path = new LinkedList<>();

        backTrack(result,path,target,candidates,0);

        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }

        return result;
    }

    private static void backTrack(List<List<Integer>> result, List<Integer> path, int target, int[] candidates,int index) {

        if (target == 0) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            if(candidates[i] > target)
                break;

            path.add(candidates[i]);
            backTrack(result,path,target-candidates[i],candidates,i);
            path.remove(path.size()-1);

        }

    }

    public static void main(String[] args) {

        combinationSum(new int[]{2,3,6,7},7);

    }
}
