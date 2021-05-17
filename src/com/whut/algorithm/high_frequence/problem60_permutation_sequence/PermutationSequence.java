package com.whut.algorithm.high_frequence.problem60_permutation_sequence;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/7 14:37
 * @desription
 */
public class PermutationSequence {


    public static String getPermutation(int n, int k) {

        StringBuilder sb = new StringBuilder();


        int[] result = new int[n];

        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = i + 1;

        for (int i = 0; i < k - 1; i++)
            result = nextPermutation(a);

        for (int i : result) {
            sb.append(i);
        }
        return sb.toString();
    }

    private static void reverse(
            int[] nums,
            int left,
            int right
    ) {
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static int[] nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return nums;

        int i = nums.length - 2;

        //找到第一个不递减的数字
        while (i >= 0 && nums[i + 1] <= nums[i])
            i--;

        if (i >= 0) {
            //寻找一个第一个比找到nums[i] 大的数字
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
                j--;

            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        reverse(nums, i + 1, nums.length - 1);

        return nums;
    }

    private static boolean flag;

    private static void backTrack(
            int n,
            int k,
            List<List<Integer>> result,
            List<Integer> path
    ) {

        if (path.size() == n) {
            result.add(new LinkedList<>(path));
            if (result.size() == k) {
                flag = true;
                return;
            }

            return;
        }

        for (int i = 1; i <= n; i++) {

            if (path.contains(i))
                continue;

            if (flag)
                return;

            path.add(i);

            backTrack(n, k, result, path);
            path.remove(path.size() - 1);

        }

    }


    public static void main(String[] args) {
        System.out.println(getPermutation(3, 1));
    }

}
