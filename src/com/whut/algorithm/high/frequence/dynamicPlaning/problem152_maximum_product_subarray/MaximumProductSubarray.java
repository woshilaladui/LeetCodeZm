package com.whut.algorithm.high.frequence.dynamicPlaning.problem152_maximum_product_subarray;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/5 11:48
 * @desription
 */
public class MaximumProductSubarray {

    public int maxSubArray(int[] nums) {

        int n = nums.length;

        int[] dpMax = new int[n];
        int[] dpMin = new int[n];

        System.arraycopy(nums, 0, dpMax, 0, n);
        System.arraycopy(nums, 0, dpMin, 0, n);

        for (int i = 1; i < n; i++) {
            dpMax[i] = getMax(
                    dpMax[i - 1] * nums[i],
                    dpMin[i - 1] * nums[i],
                    nums[i]
            );

            dpMin[i] = getMin(
                    dpMax[i - 1] * nums[i],
                    dpMin[i - 1] * nums[i],
                    nums[i]
            );
        }
        int result = dpMax[0];

        for (int i = 1; i < n; i++) {
            result = Math.max(result, dpMax[i]);
        }

        return result;
    }

    private int getMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();

        int []nums = new int[]{2,3,-2,-4};
        System.out.println(maximumProductSubarray.maxSubArray(nums));
    }


}
