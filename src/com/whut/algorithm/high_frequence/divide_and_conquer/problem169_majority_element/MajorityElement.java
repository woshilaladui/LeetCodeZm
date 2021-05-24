package com.whut.algorithm.high_frequence.divide_and_conquer.problem169_majority_element;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/24 10:41
 * @desription
 */
public class MajorityElement {

    public int majorityElementMoore(int[] nums) {
        int candNum = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (candNum == nums[i])
                ++count;
            else if (--count == 0) {
                candNum = nums[i];
                count = 1;
            }
        }
        return candNum;
    }

    /**
     * 分治的思想
     *  求左边的众数和右边众数，再合并左右众数
     * @param nums
     * @return
     */
    private int majorityElement(int[] nums) {
        return majorityElement(nums,0,nums.length-1);
    }

    private int majorityElement(int[] nums, int low, int high) {

        //终止条件
        if (low == high)
            return nums[low];

        int mid = low + (high - low) / 2;

        int leftMajorityElement = majorityElement(nums,low,mid);
        int rightMajorityElement = majorityElement(nums,mid+1,high);

        if(leftMajorityElement == rightMajorityElement)
            return leftMajorityElement;

        int leftMajorityElementCount = countInRange(nums,leftMajorityElement,low,high);
        int rightMajorityElementCount = countInRange(nums,rightMajorityElement,low,high);

        return leftMajorityElementCount > rightMajorityElementCount ? leftMajorityElement:rightMajorityElement;
    }

    private int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int result = majorityElement.majorityElement(new int[]{2,2,2,3,3});
        System.out.println(result);
    }
}
