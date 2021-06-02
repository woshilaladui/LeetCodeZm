package com.whut.algorithm.high.frequence.problem19_remove_nth_node_from_end_of_list;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/2 8:56
 * @desription
 */
public class Test {

    public static int divide2(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (divisor == 1)
            return dividend;

        if (divisor == -1)
            return -dividend;

        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;

        //将dividend divisor 符号去掉
        long noSignDividend = Math.abs((long)dividend);
        long noSignDivisor = Math.abs((long)divisor);

        int count = 0;

        /**
         *
         * 10 3
         *
         * 10 - (3*2)  = 4   4 - 3
         *
         */

        while (noSignDividend >= noSignDivisor) {

            //不能用int 会越界
            long p = noSignDivisor;
            long t = 1;

            while (noSignDividend >= (p << 1)) {
                p = p << 1;
                t = t << 1;
            }
            noSignDividend -= p;
            count += t;
        }

        return sign > 0 ? count : -count;
    }

    public static void main(String[] args) {

        //-2147483648
        //2
         System.out.println(divide2(-2147483648,2));

       // System.out.println(true ^ true);

    }
}
