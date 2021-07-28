package com.whut.algorithm.high.frequence.offer.problem_offer_47_li_wu_de_zui_da_jie_zhi_lcof;

import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/28 21:47
 * @desription
 */
public class LiWuDeZuiDaJieZhiLcof {

    /**
     *
     * 查看leetcode offer13 和 leetcode 62 不同路径
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row + 1][col + 1];

        //dp[i][j] 代表 girl[0][0]  到girl[i-1][j-1]的最大值

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {

                /**
                 *              (i-1,j)
                 * (i ,j-1)    (i,j)
                 *
                 */

                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }

        return dp[row][col];
    }

    public static void main(String[] args) {

    }
}
