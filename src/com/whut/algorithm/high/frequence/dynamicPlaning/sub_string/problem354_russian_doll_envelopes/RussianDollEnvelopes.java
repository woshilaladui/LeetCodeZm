package com.whut.algorithm.high.frequence.dynamicPlaning.sub_string.problem354_russian_doll_envelopes;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/15 20:32
 * @desription
 */
public class RussianDollEnvelopes {

    private static int maxEnvelopes(int[][] envelopes) {

        //对信封按宽度升序，而高度降序
        int n = envelopes.length;
        if (n == 0)
            return 0;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });

        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = envelopes[i][1];

        return lengthOfLIS(height);

    }

    private static int lengthOfLIS2(int[] nums) {

        int n = nums.length;

        //下标为i的能LIS
        int[] dp = new int[n];

        int result = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(
                        dp[j] + 1,//选
                        dp[i]//不选
                );
            }
            result = Math.max(dp[i], result);
        }

        return result;
    }

    private static int lengthOfLIS(int[] nums) {

        int n = nums.length;
        //扑克牌的堆数
        int piles = 0;

        //顶牌的堆数，最大为n堆
        int[] top = new int[n];

        for (int i = 0; i < n; i++) {
            int left = 0, right = piles;
            int poker = nums[i];
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] < poker)
                    left = mid + 1;
                else
                    right = mid;
            }
            //没有找到则新开一堆
            if (left == piles)
                piles++;

            //将该牌放入到新堆中
            top[left] = poker;
        }

        return piles;

    }

    public static void main(String[] args) {

        Integer[] a = new Integer[]{3,1,2};

        Com com = new Com();


        Arrays.sort(a, com);

        for (Integer integer : a) {
            System.out.print(integer+" ");
        }


    }

    static class Com implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }

    }

}
