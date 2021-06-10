package com.whut.algorithm.high.frequence.dynamicPlaning.problem887_super_egg_drop;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/18 15:51
 * @desription
 */
public class SuperEggDrop {

    public int superEggDrop(int K, int N) {

        //dp[K][m] 代表k个鸡蛋，仍m次，最坏的情况下能确定N层楼
        //最后dp[K][m] = N
        int[][] dp = new int[K + 1][N + 1];
        /**
         * dp[0][...] = 0
         * dp[...][0] = 0;
         */
        int m = 0;

        while (dp[K][m] < N) {
            //没有到达层高N，次数++
            m++;
            for (int k = 1; k <= K; k++)
                //解释:dp[k][m-1]楼上的高度 + dp[k-1][m-1] 楼下的高度 + 1 = dp[k][m] 现有能测的高度
                dp[k][m] =
                        dp[k][m - 1]//没有破碎
                                +
                                dp[k - 1][m - 1]//破碎了
                                + 1;

        }
        return m;
    }


    public static void main(String[] args) {

    }
}
