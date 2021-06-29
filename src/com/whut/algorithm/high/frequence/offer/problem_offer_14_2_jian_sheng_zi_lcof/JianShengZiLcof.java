package com.whut.algorithm.high.frequence.offer.problem_offer_14_2_jian_sheng_zi_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/28 15:58
 * @desription
 */
public class JianShengZiLcof {

    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        long res = 1;
        while (n > 4) {
            res = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);

    }


    //贪心

    /**
     * 不能是大数会越界，大数字需要每次循环处理，如上面代码
     * @param n
     * @return
     */
    public static int cuttingRope2(int n) {

        if (n == 2)
            return 1;
        if (n == 3)
            return 2;


        //尽可能的分解为3 和 4(2 * 2)  并且 2 * 2 > 3 * 1
        int sumOf3 = n / 3;

        // 2 * 2 > 3 * 1
        if (n - sumOf3 * 3 == 1)
            sumOf3 -= 1;

        int sumOf2 = (n - sumOf3 * 3) / 2;

        return (int) (Math.pow(2,sumOf2) * Math.pow(3,sumOf3));
    }

    public static void main(String[] args) {
        System.out.println(1<<0);
    }
}
