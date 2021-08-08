package com.whut.algorithm.high.frequence.offer.problem_offer_62_yuan_quan_zhong_zui_hou_sheng_xia_de_shu_zi_lcof;

import java.util.ArrayList;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/7 17:06
 * @desription
 */
public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof {

    public int lastRemaining1(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);


    }

    /**
     * dp[n,m] = (dp[n-1,m] + m) % n
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {

        /**
         *
         * dp[n,m]
         *
         * dp[5,3] = 0 1 2 3 4 = dp`[4,3] = 3 4 0 1
         * dp[4,3] = 0 1 2 3
         *
         * dp[n-1,m]   0    1   ...  n-1-m    n-m ... n-3  n-2
         * dp`[n-1,m]  m    m+1 ...  n-1
         *
         * dp`[n-1,m] = dp[n,m] = (dp[n-1,m] + m) % n
         *
         */

        int result = 0;

        for (int i = 2; i <= n; i++)
            result = (result + m) % i;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
