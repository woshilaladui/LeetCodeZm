package com.whut.algorithm.high_frequence.problem69_sqrtx;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/29 19:40
 * @desription
 */
public class Sqrtx {

    public static int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(
             mySqrt(8)
        );
    }
}
