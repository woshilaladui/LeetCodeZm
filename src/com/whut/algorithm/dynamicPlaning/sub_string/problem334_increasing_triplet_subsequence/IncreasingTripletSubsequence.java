package com.whut.algorithm.dynamicPlaning.sub_string.problem334_increasing_triplet_subsequence;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/8 15:38
 * @desription
 */
public class IncreasingTripletSubsequence {

    /**
     *
     * 不是动态规划
     *
     * 维护2个最小值，出现比这两个最小值要大的值则返回true
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;

        if (n < 3)
            return false;

        int min1 = nums[0];
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (nums[i] <= min1)
                min1 = nums[i];
            else if (nums[i] <= min2)
                min2 = nums[i];
            else //找到一个比min1,min2还要大的数字
                return true;
        }

        return false;
    }


    public static void main(String[] args) {

    }

}
