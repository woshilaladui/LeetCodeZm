package com.whut.algorithm.common.problem50_powx_n;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/8 19:23
 * @desription
 */
public class PowxN {

    /**
     * (a * b) % k = (a % k)(b % k) % k
     * <p>
     * 相当于对每个因子求模
     *
     * @return
     */
    int superPowMod(int a, int k, int base) {

        if (k == 0)
            return 1;

        //对每个因子求模
        a %= base;

        if (k % 2 == 1) {
            //奇数
            return (a * superPowMod(a, k - 1, base)) % base;
        } else {
            int sub = superPowMod(a, k / 2, base);
            return (sub * sub) % base;
        }
    }

    /**
     * 递归快速幂
     *
     * @param x
     * @param n
     * @return
     */
    public static double quickMul(double x, long n) {

        if (n == 0) {
            return 1;
        }

        double y = quickMul(x, n / 2);

        return n % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 非递归快速幂
     *
     * @param x
     * @param N
     * @return
     */
    public static double quickMu2(double x, long N) {
        double result = 1.0;
        double contibute = x;

        while (N > 0) {
            if (N % 2 == 1) {
                result *= contibute;
            }
            contibute *= contibute;
            N /= 2;
        }

        return result;

    }

    public static double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMu2(x, N) : 1.0 / quickMul(x, -N);
    }


    public static void main(String[] args) {
        System.out.println(myPow(2, 5));
    }
}
