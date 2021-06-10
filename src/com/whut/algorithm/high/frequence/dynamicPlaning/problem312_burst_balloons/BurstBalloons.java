package com.whut.algorithm.high.frequence.dynamicPlaning.problem312_burst_balloons;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/18 17:04
 * @desription
 */
public class BurstBalloons {

    public static int maxCoins(int[] nums) {

        int n = nums.length;

        //虚拟两个气球 nums[0] 和nums[n+1] 都为1 真正的气球从1-n
        int[] points = new int[n + 2];
        //初始化points[0] = points[n+1] = 1
        points[0] = points[n+1] = 1;
        System.arraycopy(nums, 0, points, 1, n);

        //dp[i][j] 代表(i,j)区间内戳爆气球最大的分数，开区间
        int[][] dp = new int[n + 2][n + 2];

        //从下往上遍历，

        for (int i = n + 1; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {

                //其中k是最后一个被戳爆的气球在(i,j)区间中
                for (int k = i + 1; k < j; k++) {
                    //做选择，选择最大dp[i][j]
                    dp[i][j] = Math.max(
                            dp[i][j],
                            dp[i][j] = dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]
                    );

                }
            }
        }

        return dp[0][n + 1];
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3, 1, 5, 8};

        System.out.println(maxCoins(nums));

        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        if (a < b) {
            System.out.println("a < b");
        }
        if (a - b < 0) {
            System.out.println("a - b < 0");
        }

    }

}
