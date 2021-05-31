package com.whut.algorithm.binary_search.problem33_search_in_rotated_sorted_array;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/31 14:32
 * @desription
 */
public class SearchInRotatedSortedArray {

    /**
     * 部分有序数组
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target)
                return mid;

            //mid 和 left 落在同一边 都落在num1中
            if (nums[mid] >= nums[left]) {
                //mid 和 target位置
                //target 在[left mid) 之间,该区间有序
                if(nums[mid] > target && target >= nums[left]){
                    right = mid -1;
                }else if(nums[mid] < target //target在num1中
                        ||
                        target < nums[left]// target 在 num2中
                ){
                    //在num1数组中并且在mid 右边，或者在num2数组中
                    //注意：num2数组中所有元素都小于num1
                    left = mid + 1;
                }
            } else {
                //mid 和 left 落在不同数组中,left在num1,mid 在num2中
                //mid 和target位置,mid在有序数组中
                if(nums[mid] < target && target <= nums[right]){
                    left = mid +1;
                }else if(target > nums[right]//target在num1中
                                ||
                        target < nums[mid]//target在num2中
                ){
                    //mid 在target左边，可能在num1 中，也可能在num2中
                    right = mid -1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
