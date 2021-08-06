package com.whut.algorithm.high.frequence.offer.problem_offer_57_2_he_wei_sde_lian_xu_zheng_shu_xu_lie_lcof;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/6 9:28
 * @desription
 */
public class HeWeiSdeLianXuZhengShuXuLieLcof {

    public int[][] findContinuousSequence(int target) {

        List<int[]> result = new ArrayList<>();

        for (int l = 1, r = 2; l < r; ) {
            // sum = n*a1(a1 + an)/2
            int sum = (r - l + 1) * (l + r) / 2;

            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    res[i - l] = i;
                }
                result.add(res);
                //满足条件窗口缩小
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        HeWeiSdeLianXuZhengShuXuLieLcof heWeiSdeLianXuZhengShuXuLieLcof = new HeWeiSdeLianXuZhengShuXuLieLcof();

        for (int[] ints : heWeiSdeLianXuZhengShuXuLieLcof.findContinuousSequence(9)) {
            System.out.println(ints);
        }

        ReentrantLock reentrantLock = new ReentrantLock();

        reentrantLock.lock();
    }
}
