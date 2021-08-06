package com.whut.algorithm.high.frequence.offer.problem_offer_57_1_he_wei_sde_liang_ge_shu_zi_lcof;

import java.util.HashMap;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/5 21:37
 * @desription
 */
public class HeWeiSdeLiangGeShuZiLcof {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        for (int num : nums) {
            if (map.containsKey(target - num))
                return new int[]{num, target - num};
        }
        return new int[]{-1, -1};
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int[] arr = new int[2];
        //这注意这里 l <=r 不可以，因为必须有num[l] num[r]
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                arr[0] = nums[l];
                arr[1] = nums[r];
                break;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
