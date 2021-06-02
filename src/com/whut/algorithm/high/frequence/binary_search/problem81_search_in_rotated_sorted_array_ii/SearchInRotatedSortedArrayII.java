package com.whut.algorithm.high.frequence.binary_search.problem81_search_in_rotated_sorted_array_ii;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/31 15:02
 * @desription
 */
public class SearchInRotatedSortedArrayII {

    /**
     * 数组部分有序
     * num1,num2分别有序
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        /**
         * num1 num2数组分别是有序数组
         *
         * num2数组的所有元素都要比num1小
         */
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target)
                return true;

            //跳过重复元素
            if(nums[mid] == nums[left]){
                left++;
                continue;
            }

            //left 和 mid 都在num1数组中
            if (nums[mid] >= nums[left]){
                //判断target和mid相对位置
                //注意nums[mid] != target这里，上面循环有判断 nums[mid] == target
                //说明在有序区间[left,mid)
                if(nums[mid] > target && target >= nums[left]){
                    right = mid - 1;
                }else if(nums[mid] < target//在num1中，并且在mid右边
                        ||
                        target < nums[left]
                ){
                    //mid 可能在num1中，也可能在mum2中
                    left = mid + 1;
                }
            }else {//mid 在num2中
                //说明在(mid,right]有序区间中
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else if(nums[mid] > target//在num2中，并且在mid左边
                        ||
                        target > nums[right]//在num1中
                ){
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        /**
         * [2,5,6,0,0,1,2]
         * 3
         */
        SearchInRotatedSortedArrayII searchInRotatedSortedArrayII = new SearchInRotatedSortedArrayII();

        System.out.println(searchInRotatedSortedArrayII.search(new int[]{2,5,6,0,0,1,2},3));

    }
}
