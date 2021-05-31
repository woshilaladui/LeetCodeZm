package com.whut.algorithm.binary_search.problem153_find_minimum_in_rotated_sorted_array;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/31 11:14
 * @desription
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            //一开始是有序数组
            if (nums[left] <= nums[right])
                return nums[left];

            int mid = left + (right - left) / 2;

            //说明在[left,mid]之间单调递增，不在这里面
            if(nums[mid] >= nums[left]){
                left = mid + 1;
            }else {
                //mid在数组二中
                //不能right = mid -1.有可能mid刚好是最小值
                right = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();

        System.out.println(findMinimumInRotatedSortedArray.findMin(new int[]{2,2,2,0,1}));
    }
}
