package com.whut.algorithm.high.frequence.backTrack.problem40_combination_sum_ii;

import java.util.*;

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

    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();

        boolean[] vis = new boolean[candidates.length];
        backTrack2(candidates, target, result, path, vis);
        return result;
    }

    private void backTrack2(
            int[] candidates,
            int target,
            List<List<Integer>> result,
            List<Integer> path,
            boolean[] vis
    ) {

        if (target == 0) {
            result.add(new LinkedList<>(path));
            return;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < candidates.length; i++) {

            if(target < 0)
                break;

            if(set.contains(candidates[i]) || vis[i]){
                continue;
            }

            set.add(candidates[i]);
            vis[i] = true;
            path.add(candidates[i]);
            backTrack2(candidates,target-candidates[i],result,path,vis);
            vis[i] = false;
            path.remove(path.size()-1);

        }

    }

    private void backTrack(
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
        TreeMap<String , Double> map =  new TreeMap<String, Double>();
        map.put("ccc" , 89.0);
        map.put("aaa" , 80.0);
        map.put("zzz" , 80.0);
        map.put("bbb" , 89.0);
        System.out.println(map);

        TreeSet<String> set = new TreeSet<>();


    }
}
