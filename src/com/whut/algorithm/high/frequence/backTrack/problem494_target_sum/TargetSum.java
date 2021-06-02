package com.whut.algorithm.high.frequence.backTrack.problem494_target_sum;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/1 14:15
 * @desription
 */
public class TargetSum {


    private static void backTrack(
            int[] nums,
            List<Integer> path,
            Set<List<Integer>> result,
            int S,
            boolean[] visited
    ) {
        if (path.size() == nums.length) {
            if (S == 0) {

                List<Integer> temp = new LinkedList<>(path);
                Collections.sort(temp);

                result.add(new LinkedList<>(temp));

                return;
            }

        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i])
                continue;

            //去除重复集合
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1])
                continue;

            path.add(-nums[i]);
            visited[i] = true;
            backTrack(nums, path, result, S + nums[i], visited);
            path.remove(path.size() - 1);
            visited[i] = false;

            path.add(nums[i]);
            visited[i] = true;
            backTrack(nums, path, result, S - nums[i], visited);
            path.remove(path.size() - 1);
            visited[i] = false;

        }

    }

    private static int findTargetSumWays(int[] nums, int S) {

        List<Integer> path = new LinkedList<>();

        Set<List<Integer>> result = new HashSet<>();

        boolean[] visited = new boolean[nums.length];
        backTrack(nums, path, result, S, visited);


        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
        return result.size();
    }

    public static void main(String[] args) {


        int count = 0;
        int[] nums = new int[]{0,0,0,0,0,0,0,0,1};
        for(int i=0;i<nums.length;i++)
            if(nums[i] == 0)
                count++;
        int S = 1;


        int result = (int) (findTargetSumWays(nums, S)+Math.pow(2,count));

        System.out.println(result);
    }
}
