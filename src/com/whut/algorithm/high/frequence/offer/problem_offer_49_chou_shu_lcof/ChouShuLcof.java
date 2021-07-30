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
