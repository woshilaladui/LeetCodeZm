package com.whut.algorithm.backTrack.problem78_subsets;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/11 19:09
 * @desription
 */
public class Subsets {


    /**
     * 通过位运算来解题
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>>  subsets(int[] nums) {

        Set<List<Integer>> tempResult = new HashSet<>();

        //一共有2^n次方的可能
        int setNum = 1 << nums.length;

        //遍历这些集合
        for (int i = 0; i < setNum; i++) {

            List<Integer> temp = new ArrayList<>();

            /**
             * i代表集合0-2^n-1个集合
             * (1<<j)表示构造nums数组的第j个元素
             */

            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) >= 1) {
                    temp.add(nums[j]);
                }
            }

            //防止出现重复的集合
            Collections.sort(temp);

            tempResult.add(new ArrayList<>(temp));

        }



        return new ArrayList<>(tempResult);

    }


    private static void backTrack(
            int[] nums,
            List<List<Integer>> result,
            List<Integer> path,
            int index
    ){
        result.add(new LinkedList<>(path));

        //不确定拿几个所以i=index
        for(int i=index;i<nums.length;i++){

            //不需要去重复
            path.add(nums[i]);
            backTrack(nums,result,path,i+1);
            path.remove(path.size()-1);

        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2, 1, 2, 2};

        List<List<Integer>> result = subsets(nums);


        for (List<Integer> list : result) {

            if (list.size() == 0) {
                // System.out.println("aaaaaa");
                System.out.print("[]");
            } else {
                for (Integer integer : list) {
                    System.out.print(integer + " ");
                }
            }
            System.out.println();


        }

    }
}
