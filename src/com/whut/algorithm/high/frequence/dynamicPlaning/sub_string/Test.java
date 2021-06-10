package com.whut.algorithm.high.frequence.dynamicPlaning.sub_string;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/20 17:19
 * @desription
 */
public class Test {


    public static int lenLongestFibSubseq(int[] arr) {

        int n = arr.length;

        int maxLen = 2;

        /**
         * 以arr[i],arr[j]结尾的最长斐波那契式子序列个数
         *
         * 故有关系
         * arr[k] + arr[i] = arr[j]
         *
         * dp[i][j] = max(dp[i][j],dp[k][i]+1)
         *
         * 关键问题就是来寻找我们的k
         *
         * for (int i = 0; i < n; i++) {
         * 		for (int j = i + 1; j < n; j++) {
         * 			for (int k = i - 1; k >= 0; k--) {
         * 				if (A[k] + A[i] == A[j]) {
         * 					dp[i][j] = max(dp[i][j], dp[k][i] + 1);
         *                                }* 			}
         * 			MAX = max(MAX, dp[i][j]);
         *        }
         *    }
         *
         *
         * 但是3重循环会超时，所以建立map来关联arr[k] k->arr[j]-arr[i]  k
         *
         *
         * 为了降低时间复杂读
         */
        int[][] dp = new int[n][n];

        //base case
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
                dp[i][j] = 2;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++)
            map.put(arr[i], i);


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int arrK = arr[j] - arr[i];
                //在map中找strLen对应的下标
                if (map.containsKey(arrK)) {
                    int k = map.get(arrK);
                    if (k < i) {
                        //k<i<j
                        dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);

                    }

                }
                maxLen = Math.max(maxLen, dp[i][j]);

            }
        }

        return maxLen > 2 ? maxLen : 0;

    }

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(true);

        Thread t1 = new Thread();

        lock.lock();
        t1.start();
        //做了10秒
        lock.unlock();

        lock.lock();
        new Thread(()->{
            try {
                Thread.sleep(10);
                //t2处理业务
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        lock.unlock();
    }
}
