package com.whut.algorithm.high.frequence.dynamicPlaning.rob.problem213_house_robber_ii;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/3 15:07
 * @desription
 */
public class HouseRobberII {

    public static int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        if (nums.length == 0)
            return 0;

        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int n = nums.length;

        return Math.max(
                //只需要讨论3种情况
                /**
                 * 0 - (n-2)
                 * 1-(n-2)
                 * 1 -(n-1)
                 *
                 * 画图可以明白
                 */
                robRange(nums,0,n-2),
                robRange(nums,1,n-1)
        );

    }

    private static int robRange(int[] nums, int start, int end) {

        int dp_i = 0, dp_i_1 = 0, dp_i_2 = 0;
        for (int i = start; i <= end; i++) {
            dp_i = Math.max(dp_i_1, dp_i_2 + nums[i]);
            //注意顺序不能错，画图可以明白
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;

        }

        return dp_i;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,1};

        System.out.println(rob(nums));

    }

}
