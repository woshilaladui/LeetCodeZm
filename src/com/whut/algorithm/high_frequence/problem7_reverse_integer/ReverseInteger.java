package com.whut.algorithm.high_frequence.problem7_reverse_integer;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/1 20:17
 * @desription
 */
public class ReverseInteger {

    public static int reverse(int x) {
//        int rev = 0;
//        while (x != 0) {
//            int pop = x % 10;
//            x /= 10;
//            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
//            //if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
//            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
//                return 0;
//            rev = rev * 10 + pop;
//        }
//        return rev;


        int result = 0;
        int pop = 0;

        while (x != 0) {
            pop = x % 10;
            x /= 10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;

            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;

            result = result * 10 + pop;
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
