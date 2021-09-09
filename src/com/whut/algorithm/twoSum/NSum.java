package com.whut.algorithm.twoSum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/2 16:50
 * @desription
 */
public class NSum {


    private static List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {

        int sz = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        //递归反回条件
        //至少是2sum,且数组大小不应该小于n
        if (n < 2 || sz < n)
            return result;

        //base case
        if (n == 2) {
            int low = start, high = sz - 1;
            while (low < high) {

                int sum = nums[low] + nums[high];
                //left,high 是为了去重复的
                int left = nums[low], right = nums[high];
                //变大点
                if (sum < target) {
                    while (low < high && nums[low] == left)
                        low++;
                } else if (sum > target) {
                    while (low < high && nums[high] == right)
                        high--;
                } else {
                    //找到满足的结果
                    //存放结果，不是下标
                    List<Integer> path = new ArrayList<>(Arrays.asList(left, right));
                    result.add(path);

                    //去重
                    while (low < high && nums[low] == left)
                        low++;

                    while (low < high && nums[high] == right)
                        high--;

                }
            }
        } else {
            //n > 2
            //递归计算(n-1)Sum
            for (int i = start; i < sz; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);

                //(n-1)Sum + nums[i] 就是NSum
                for (List<Integer> list : sub) {
                    list.add(nums[i]);
                    result.add(list);
                }

                //去重
                while (i < sz - 1 && nums[i] == nums[i + 1])
                    i++;
            }
        }

        return result;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = nSumTarget(nums, 3, 0, target);

        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
        return nSumTarget(nums, 3, 0, target);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {

        int []nums = new int[]{-1,0,1,2,-1,-4};
        Arrays.sort(nums);
//        List<List<Integer>> result = nSumTarget(nums, 3, 0, 7);
//
//        for (List<Integer> list : result) {
//            for (Integer integer : list) {
//                System.out.print(integer + ",");
//            }
//            System.out.println();
//        }
        return nSumTarget(nums, k, 0, n);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum3(3,0);

        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }


    }
}
