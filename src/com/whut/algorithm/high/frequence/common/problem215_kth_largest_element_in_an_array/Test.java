package com.whut.algorithm.high.frequence.common.problem215_kth_largest_element_in_an_array;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/10 12:07
 * @desription
 */
public class Test {
    public int singleNumber(int[] nums) {

        //统计二进制位出现的次数
        int[] count = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                count[j] += num & 1;
                num >>>= 1;
            }
        }
        //注意高低位

        int result = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            //反向还原
            int flag = count[31 - i] > nums.length / 2 ? 1 : 0;
            result |= flag;
        }
        return result;
    }
}
