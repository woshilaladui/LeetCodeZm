package com.whut.algorithm.high.frequence.common.problem405_convert_a_number_to_hexadecimal;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/9 20:19
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(add(75,-29));
    }

    private static int add(int a, int b) {
        while ((a & b) != 0) {
            int tmp = a;
            a = (a & b)<<1;
            b ^=tmp;
        }
        return a^b;
    }
}
