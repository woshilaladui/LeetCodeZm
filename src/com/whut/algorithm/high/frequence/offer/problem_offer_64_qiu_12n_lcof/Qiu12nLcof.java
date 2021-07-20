package com.whut.algorithm.high.frequence.offer.problem_offer_64_qiu_12n_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/20 21:14
 * @desription
 */
public class Qiu12nLcof {

    /**
     *
     class Solution {
     public:
     int sumNums(int n) {
     return n == 0 ? 0 : n + sumNums(n - 1);
     }
     };
     * @param n
     * @return
     */

    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {

    }
}
