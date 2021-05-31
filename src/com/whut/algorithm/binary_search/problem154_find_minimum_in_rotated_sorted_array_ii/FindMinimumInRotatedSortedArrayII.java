package com.whut.algorithm.binary_search.problem154_find_minimum_in_rotated_sorted_array_ii;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/31 15:47
 * @desription
 */
public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        int mid = 0;

        while (left <= right) {
            if (nums[left] < nums[right])
                return nums[left];

            mid = left + (right - left) / 2;

            if (nums[mid] == nums[left]) {
                //思想和81一样跳过重复元素
                //跳过重复元素
                left++;
            } else if (nums[mid] > nums[left]) {
                //说明区间有序，递增,最小值不可能在这里出现
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[mid];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArrayII findMinimumInRotatedSortedArrayII = new FindMinimumInRotatedSortedArrayII();
        System.out.println(findMinimumInRotatedSortedArrayII.findMin(new int[]{3, 1, 3}));
    }
}
