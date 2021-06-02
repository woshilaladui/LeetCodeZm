package com.whut.algorithm.high.frequence.problem69_sqrtx;

import java.util.*;


/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/29 19:51
 * @desription
 */
public class Test {

    public static List<List<Integer>> combine(int []nums) {

        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();

        Arrays.sort(nums);


        for (int num : nums) {

        }

        backTrack(0, result, path, nums);

//        for (List<Integer> list : result) {
//            for (Integer integer : list) {
//                System.out.print(integer+" ");
//            }
//            System.out.println();
//        }

        return result;
    }

    private static void backTrack(int start, List<List<Integer>> result, LinkedList<Integer> path, int[] nums) {

        result.add(new LinkedList<>(path));

        Set<Integer> set = new HashSet<>();

        for (int i = start; i < nums.length; i++) {

            if(set.contains(nums[i]))
                continue;

            set.add(nums[i]);
            path.addLast(nums[i]);

            backTrack(i+1,result,path,nums);

            path.removeLast();

        }

    }

    public static void main(String[] args) {
        combine(new int[]{1,2,2});
    }
}
