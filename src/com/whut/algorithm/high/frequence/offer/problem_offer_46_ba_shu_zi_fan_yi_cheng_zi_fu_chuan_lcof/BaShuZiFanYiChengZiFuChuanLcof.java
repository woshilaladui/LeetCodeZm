package com.whut.algorithm.high.frequence.offer.problem_offer_46_ba_shu_zi_fan_yi_cheng_zi_fu_chuan_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/28 21:12
 * @desription
 */
public class BaShuZiFanYiChengZiFuChuanLcof {

    /**
     * 和leetcode 91题目类似
     *
     * `dp[i] = 以自身去编码（一位） + 以前面的元素和自身去编码（两位）` .这显然是完备的，
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {

        String s = String.valueOf(num);
        int n = s.length();

        //代表以i位置结尾可以构成的总数
        int[] dp = new int[n];

        if(s.charAt(0) == '0')
            return 1;

        dp[0] = 1;

        char[] charArray = s.toCharArray();

        for (int i = 1; i < n; i++) {
            //本身这一位
            dp[i] = dp[i - 1];

            if (charArray[i-1] == '1' || charArray[i - 1] == '2' && charArray[i] <= '5') {
                if (i - 2 >= 0) {
                    dp[i] += dp[i - 2];
                } else
                    dp[i]++;
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

    }
}
