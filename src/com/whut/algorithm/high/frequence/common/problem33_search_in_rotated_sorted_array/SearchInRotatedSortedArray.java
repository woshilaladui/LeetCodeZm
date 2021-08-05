package com.whut.algorithm.high.frequence.common.problem33_search_in_rotated_sorted_array;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/2 15:01
 * @desription
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {

        int n = nums.length;

        if (n == 1)
            return target == nums[0] ? 0 : -1;

        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (r + l) / 2;

            if (nums[mid] == target)
                return mid;

            //判断左边有序还是右边有序
            if (nums[0] <= nums[mid]) {
                //左边有序
                //查看target是不是在有序区间中
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            }else {
                //右边有序
                if(nums[mid] < target && target <= nums[n-1]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }

            }

        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
