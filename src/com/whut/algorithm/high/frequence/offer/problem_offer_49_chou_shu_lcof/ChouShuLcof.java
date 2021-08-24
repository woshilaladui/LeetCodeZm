package com.whut.algorithm.high.frequence.offer.problem_offer_49_chou_shu_lcof;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/30 20:07
 * @desription
 */
public class ChouShuLcof {


    public int nthUglyNumber2(int n) {
        int a = 0, b = 0, c = 0;

        int[] dp = new int[n];

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;

            dp[i] = Math.min(n2,Math.min(n3,n5));

            if(dp[i] == n2)
                a++;
            if(dp[i] == n3)
                b++;
            if (dp[i] == n5)
                c++;
        }

        return dp[n-1];
    }

    public int nthUglyNumber(int n) {

        int[] factors = {2, 3, 5};

        Set<Long> seen = new HashSet<>();

        PriorityQueue<Long> heap = new PriorityQueue<>();

        seen.add(1L);
        heap.add(1L);

        int ugly = 0;

        for (int i = 0; i < n; i++) {

            long cur = heap.poll();

            ugly = (int) cur;

            for (int factor : factors) {
                if (seen.add(factor * cur)) {
                    heap.add(factor * cur);
                }
            }
        }

        return ugly;
    }

    public static void main(String[] args) {
        ChouShuLcof chouShuLcof = new ChouShuLcof();

        System.out.println(chouShuLcof.nthUglyNumber(10));
    }
}
