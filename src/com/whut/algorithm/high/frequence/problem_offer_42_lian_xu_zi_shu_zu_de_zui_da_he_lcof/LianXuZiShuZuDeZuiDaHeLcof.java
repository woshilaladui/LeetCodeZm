package com.whut.algorithm.high.frequence.problem_offer_42_lian_xu_zi_shu_zu_de_zui_da_he_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/19 20:43
 * @desription
 */
public class LianXuZiShuZuDeZuiDaHeLcof {

    public static int maxSubArray(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        dp[0] = nums[0];

        int result = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(dp[i],result);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
