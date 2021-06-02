package com.whut.algorithm.high.frequence.problem491_increasing_subsequences;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/26 17:07
 * @desription
 */
public class IncreasingSubsequences {

    public static List<List<Integer>> findSubsequences(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();

        List<Integer> path = new LinkedList<>();

        backTrack(nums,0,result,path);

        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }

        return result;
    }

    private static void backTrack(int[] num, int index, List<List<Integer>> result, List<Integer> path) {
        if (path.size() > 1) {
            result.add(new LinkedList<>(path));
            //不能return  后序还有数据集
            //return;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = index; i < num.length; i++) {

            if (!set.contains(num[i]) && (path.size() == 0 || num[i] >= path.get(path.size() - 1))) {
                set.add(num[i]);
                path.add(num[i]);
                backTrack(num, i + 1, result, path);
                path.remove(path.size() - 1);
            }

        }
    }

    public static void main(String[] args) {

        findSubsequences(new int[]{4,6,7,7});
    }
}
