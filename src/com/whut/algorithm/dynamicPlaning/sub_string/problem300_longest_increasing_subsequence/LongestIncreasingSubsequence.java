package com.whut.algorithm.dynamicPlaning.sub_string.problem300_longest_increasing_subsequence;

import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/7 16:01
 * @desription
 */
public class LongestIncreasingSubsequence {

    private static int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int result = 1;

        //dp[i]代表以i未下标结尾的子序列中最大的升序列
        int[] dp = new int[n];

        //初始化
        //初始化中每个以i为结尾中，至少有一个，即为自身
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //选自身 和不选自身
                    dp[i] = Math.max(
                            dp[j] + 1,//选
                            dp[i]//不选
                    );
                }


            }
            result = Math.max(result, dp[i]);
        }

        for (int i = 0; i < n; i++)
            System.out.print(dp[i] + " ");
        System.out.println();

        return result;
    }

    /**
     * 扑克牌解法
     *
     * @param nums
     * @return
     */
    private static int lengthOfLIS2(int[] nums) {

        //扑克牌的堆数
        int piles = 0;
        int n = nums.length;
        //最大堆数
        int[] top = new int[n];

        //遍历扑克牌
        for (int i = 0; i < n; i++) {
            //要处理的扑克牌
            int poker = nums[i];

            int left = 0, right = piles;
            //二分查找扑克牌放入哪一堆，优先放在最左边那一堆
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= poker) {
                    right = mid;
                } else
                    left = mid + 1;
            }

            //没有新堆了，新开一堆
            if (left == piles)
                piles++;

            top[left] = poker;

        }

        return piles;

    }

    public static void main(String[] args) {

        //[1,3,6,7,9,4,10,5,6]
        int[] nums = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lengthOfLIS(nums));

    }

}
