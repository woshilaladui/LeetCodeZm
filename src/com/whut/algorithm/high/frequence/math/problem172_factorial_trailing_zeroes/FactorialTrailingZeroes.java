package com.whut.algorithm.high.frequence.math.problem172_factorial_trailing_zeroes;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/17 9:29
 * @desription
 */
public class FactorialTrailingZeroes {

    /**
     * 计算n! 后面的零的个数
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {

        if (n < 5)
            return 0;

        int count = 0;

        while (n > 0) {
            count += n / 5;

            n /= 5;
        }

        return count;
    }

    public int trailingZeroes1(int n) {

        if (n < 5)
            return 0;

        int count = 0;

        for (int i = 5; i <= n; i++) {

            int N = i;

            while (N > 0) {
                if (N % 5 == 0) {
                    count++;
                    N /= 5;
                } else
                    break;
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
