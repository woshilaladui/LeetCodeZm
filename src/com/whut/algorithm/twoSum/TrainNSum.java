package com.whut.algorithm.twoSum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/9 14:44
 * @desription
 */
public class TrainNSum {
    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum3(3,8);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {

        int []nums = new int[]{1,1,2,2,3,3,4,4,5,5};
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


    private static List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int sz = nums.length;
        //递归反回条件
        //至少是2sum,且数组大小不应该小于n
        if (n < 2 || sz < n)
            return result;
        if (n == 2) {
            int low = start;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[low] + nums[high];
                int left = nums[low];
                int right = nums[high];

                if (sum < target) {
                    //去重
                    //while (low < high && nums[low] == left)
                        low++;
                } else if (sum > target) {
                    //去重
                    //while (low < high && nums[high] == right)
                        high--;
                } else {
                    List<Integer> path = new ArrayList<>(Arrays.asList(left, right));
                    result.add(path);
                    high--;
                    low++;
                    //去重
//                    while (low < high && nums[high] == right)
//                        high--;
//                    while (low < high && nums[low] == left)
//                        low++;
                }
            }

        } else {
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> sub = nSumTarget(
                        nums,
                        n - 1,
                        i + 1,
                        target - nums[i]
                );

                for (List<Integer> list : sub) {
                    list.add(nums[i]);
                    result.add(list);
                }
                //去重
//                while (i < sz - 1 && nums[i] == nums[i + 1])
//                    i++;
            }
        }//end if
        return result;
    }
}
