package com.whut.algorithm.high.frequence.common.problem238_product_of_array_except_self;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/17 9:44
 * @desription
 */
public class ProductOfArrayExceptSelf {

    /**
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     * <p>
     * <p>
     * 对于2来说
     * 1  2  3   4
     * output(2) = (2)的前缀 * (2)的后缀  = 1 * 3 * 4 = 12
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {

        int[] L = new int[nums.length];

        int[] R = new int[nums.length];

        int[] output = new int[nums.length];

        L[0] = 1;
        //计算左前缀
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        R[nums.length - 1] = 1;
        //计算右后缀
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        //计算结果
        for(int i = 0;i < nums.length;i++){
            output[i] = L[i] * R[i];
        }

        return output;
    }

    public static void main(String[] args) {

    }

}
