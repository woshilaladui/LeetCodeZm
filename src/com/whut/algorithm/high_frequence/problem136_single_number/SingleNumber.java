package com.whut.algorithm.high_frequence.problem136_single_number;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/14 12:16
 * @desription
 */
public class SingleNumber {



    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single = single ^ num;
      //      single ^= num;
        }
        return single;

    }
    public static void main(String[] args) {
        int []nums = new int[]{1,2,2,1,4,5,5};
        System.out.println(singleNumber(nums));

        System.out.println(1^2);
    }
}
