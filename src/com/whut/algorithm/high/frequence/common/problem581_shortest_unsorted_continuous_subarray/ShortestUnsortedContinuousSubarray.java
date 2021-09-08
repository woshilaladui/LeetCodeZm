package com.whut.algorithm.high.frequence.common.problem581_shortest_unsorted_continuous_subarray;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/8 10:24
 * @desription
 */
public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] tempNums = new int[nums.length];
        System.arraycopy(nums, 0, tempNums, 0, nums.length);
        Arrays.sort(tempNums);
        int left = 0;
        int right = nums.length - 1;

        while (left < nums.length && nums[left] == tempNums[left])
            left++;
        if (left == nums.length)
            return 0;

        while (nums[right] == tempNums[right])
            right--;

        return right - left + 1;
    }

    public int findUnsortedSubarray1(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE;
        int minn = Integer.MAX_VALUE;
        int left = -1;
        int right = -1;
        //numsa 所以元素小于 numsb  numsc
        //numsc 所有元素大于 numsa numcb

        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - 1 - i];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {

    }
}
