package com.whut.algorithm.high_frequence.problem_191_number_of_1_bits;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/15 10:54
 * @desription
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0)
                result++;

        }

        return result;
    }


    public static void main(String[] args) {

    }

}
