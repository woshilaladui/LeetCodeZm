package com.whut.algorithm.high.frequence.common.problem_75_sort_colors;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/24 15:54
 * @desription
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int zeroP = 0;
        int twoP = nums.length - 1;

        int i = 0;

        /**
         * a[0,zeroP)
         * a[zeroP,twoP)
         * a[twoP,len-1]
         */

        while (i <= twoP) {
            if (nums[i] == 0) {
                swap(nums,i,zeroP);
                zeroP++;
                i++;
            }else if(nums[i] == 1){
                i++;
            }else {
                swap(nums,i,twoP);
                twoP--;
            }
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

    }
}
