package com.whut.algorithm.high.frequence.common.problem215_kth_largest_element_in_an_array;

import java.util.Optional;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/9 20:46
 * @desription
 */
public class TrainKthLargestElementInAnArray {

    private int partion(int []nums,int low,int high){

        int pivotKey = nums[low];

        while (low < high){

            while (low <high && nums[high] >= pivotKey)
                high--;

            nums[low] = nums[high];

            while (low <high && nums[low] <= pivotKey)
                low++;

            nums[high] = nums[low];

        }

        nums[low] = pivotKey;

        return low;

    }

    private int quickSelectSort(int[] nums, int low, int high, int k) {
        if (low <= high) {
            int privLoc = partion(nums,low,high);
//
            if(privLoc == k)
                return privLoc;
//
            if (privLoc > k) {
                quickSelectSort(nums, low, privLoc - 1, k);
            } else {
                quickSelectSort(nums, privLoc + 1, high, k);
            }
        }
        return k;
    }

    public int findKthLargest(int[] nums, int k) {
        quickSelectSort(nums, 0, nums.length - 1, nums.length-k);
//        for (int num : nums) {
//            System.out.print(num+" ");
//        }
//        System.out.println();
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        TrainKthLargestElementInAnArray trainKthLargestElementInAnArray = new TrainKthLargestElementInAnArray();

        int []nums = new int[]{3,2,3,1,2,4,5,5,6};




        int result = trainKthLargestElementInAnArray.findKthLargest(nums,4);
        for (int num : nums) {
            System.out.print(num+" ");
        }
        System.out.println();
        System.out.println(result);
    }
}
