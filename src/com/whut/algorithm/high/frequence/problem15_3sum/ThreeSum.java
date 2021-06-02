package com.whut.algorithm.high.frequence.problem15_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/19 20:17
 * @desription
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = nSumTarget(nums,3,0,0);

        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer+",");
            }
            System.out.println();
        }

        return nSumTarget(nums, 3, 0, 0);
    }

    private static List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (n < 2 || nums.length < n)
            return result;

        if (n == 2) {
            int low = start, high = nums.length - 1;

            while (low < high) {
                int sum = nums[low] + nums[high];

                int left = nums[low], right = nums[high];

                if (sum < target) {
                    //去重
                    while (low <= high && nums[low] == left)
                        low++;
                } else if (sum > target) {
                    while (low <= high && nums[high] == right)
                        high--;
                } else {
                    List<Integer> path = new ArrayList<>(Arrays.asList(left, right));

                    result.add(path);

                    //再次去重
                    while (low <= high && nums[low] == left)
                        low++;

                    while (low <= high && nums[high] == right)
                        high--;
                }

            }

        } else {
            //n > 2
            //递归计算(n-1)Sum
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> sub = nSumTarget(nums,n-1,i+1,target-nums[i]);

                //(n-1)Sum + nums[i] 就是NSum
                for (List<Integer> list : sub) {
                    list.add(nums[i]);
                    result.add(list);
                }

                //去重
                while (i < nums.length - 1 && nums[i] == nums[i + 1])
                    i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int []nums = new int[]{-1,0,1,2,-1,-4};
        threeSum(nums);
    }
}
