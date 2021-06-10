package com.whut.algorithm.high.frequence.dynamicPlaning.sub_string.problem1218_longest_arithmetic_subsequence_of_given_difference;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/8 15:47
 * @desription 和leetcode1027 题目相似
 * <p>
 * 但是1027中的公差不固定，而此题公差固定
 */
public class LongestArithmeticSubsequenceOfGivenDifference {


    /**
     * 采用数组代替map
     * <p>
     * int n = arr.size();
     * int stdd = 1e5;
     * vector<int> dp(2e5);
     * <p>
     * int ans = 0;
     * for (int i = 0; i < n; i++) {
     * int idx = stdd + arr[i]; // 加偏置，保证idx >= 0
     * dp[idx] = max(dp[idx] , dp[idx-difference] + 1);
     * dp[idx] = max(dp[idx],1); // 如果dp[idx] = 0; 将其置1
     * ans = max(ans, dp[idx]);
     * }
     * return ans;
     *
     * @param arr
     * @param difference
     * @return
     */
    public static int longestSubsequence3(int[] arr, int difference) {

        int max = 1;
        int n = arr.length;

        int stdd = 10000;
        int[] dp = new int[20000];
        //Arrays.fill(dp,1);
        for (int i = 0; i < n; i++) {
            int idx = stdd + arr[i]; // 加偏置，保证idx >= 0
            dp[idx] = Math.max(dp[idx], dp[idx - difference] + 1);
            dp[idx] = Math.max(dp[idx], 1); // 如果dp[idx] = 0; 将其置1
            max = Math.max(max, dp[idx]);
        }

        return max;
    }

    /**
     * // 2.遍历数组arr， 同时更新dp数组
     * i = 0 | arr[i] = 1 | dp[1] = 1
     * <p>
     * i = 1 | arr[i] = 5 | dp[5] = 1
     * <p>
     * i = 2 | arr[i] = 7 | dp[7] = 1
     * <p>
     * i = 3 | arr[i] = 8 | dp[8] = 1
     * <p>
     * i = 4 | arr[i] = 5 | dp[5] = 2  // 注意：5 = 7 - 2 故 dp[5] = max(dp[5], dp[7] + 1) = 2
     * <p>
     * i = 5 | arr[i] = 3 | dp[3] = 3  // 注意：3 = 5 - 2 故 dp[3] = max(dp[3], dp[5] + 1) = 3
     * <p>
     * i = 6 | arr[i] = 4 | dp[4] = 1
     * <p>
     * i = 7 | arr[i] = 2 | dp[2] = 2  // 注意：2 = 4 - 2 故 dp[2] = max(dp[2], dp[4] + 1) = 2
     * <p>
     * i = 8 | arr[i] = 1 | dp[1] = 4  // 注意：1 = 3 - 2 故 dp[1] = max(dp[1], dp[3] + 1) = 4
     *
     * @param arr
     * @param difference
     * @return
     */
    public static int longestSubsequence2(int[] arr, int difference) {

        //dp[i] 代表以数字i结尾的最大子序列的长度
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for (int num : arr) {
            if (map.containsKey(num - difference)) {
                /**
                 * i = 0 | arr[i] = 1 | dp[1] = 1
                 * i = 1 | arr[i] = 5 | dp[5] = 1
                 * i = 2 | arr[i] = 7 | dp[7] = 2   dp[7] = dp[5]+1
                 */
                //dp[7] = dp[5] +1;
                map.put(num, map.get(num - difference) + 1);
                max = Math.max(max, map.get(num));
            } else {
                map.put(num, 1);
            }
        }

        return max;
    }

    /**
     * O(n2) 会超时
     *
     * @param arr
     * @param difference
     * @return
     */
    public static int longestSubsequence(int[] arr, int difference) {

        int n = arr.length;

        //以nums[i]结尾的longestSubsequence 这样会超时
        int[] dp = new int[n];

        int max_length = 0;

        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] - arr[j] == difference)
                    dp[i] = dp[j] + 1;
            }
            max_length = Math.max(max_length, dp[i]);
        }

        return max_length;
    }


    public static void main(String[] args) {

        //int[] nums = new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1};
        int[] nums = new int[]{1, 2, 3, 4};

        System.out.println(longestSubsequence3(nums, 1));

    }
}
