package com.whut.algorithm.high.frequence.math.problem231_power_of_two;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/18 9:11
 * @desription
 */
public class PowerOfTwo {

    /**
     *
     * 8 -> 1 0 0 0
     * 7 -> 0 1 1 1
     *
     * 8 & 7 = 0
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {

        return n > 0 && (n & (n-1)) == 0;
    }

    public static void main(String[] args) {

    }

}
