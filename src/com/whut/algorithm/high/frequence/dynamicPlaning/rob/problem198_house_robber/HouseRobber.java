package com.whut.algorithm.high.frequence.dynamicPlaning.rob.problem198_house_robber;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/3 14:47
 * @desription
 */
public class HouseRobber {

    private static int rob2(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        if (nums.length == 0)
            return 0;

        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int n = nums.length;
        int dp_i = 0, dp_i_1 = 0, dp_i_2 = 0;

        // dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        //dp_i dp_i_1 dp_i_2
        //dp[i]只于i-1和i-2有关
        for (int i = 0; i < n; i++) {

            dp_i = Math.max(dp_i_1, dp_i_2 + nums[i]);
            //注意顺序不能错，画图可以明白
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;

        }


        return dp_i;
    }

    private static int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        if (nums.length == 0)
            return 0;

        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];

        //初始化

        dp[1] = Math.max(nums[0], nums[1]);
        dp[0] = nums[0];

        /**
         * 状态转移方程
         *
         * 选择第i号房间则;第i个房间+前i-2个房间的最优解
         * 不选择第i号房间：就是前i-1个房间的最优解
         * dp[i] = max(dp[i-1],dp[i-2]+nums[i])
         */
        for (int i = 2; i < nums.length; i++) {

            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

        }

        return dp[nums.length - 1];

    }

    public static void main(String[] args) {

        int[] nums = new int[]{2,7,9,3,1};

        System.out.println(rob2(nums));

    }

}
