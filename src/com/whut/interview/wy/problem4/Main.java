package com.whut.interview.wy.problem4;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/21 16:04
 * @desription
 */
public class Main {

    int[][] direction = new int[][]{
            {0, 1},//右
            {1, 0},//下
            {0, -1},//左
            {-1, 0}
    };

    public int minSailCost(int[][] input) {
        // write code here
        int row = input.length;
        int col = input[0].length;

        int result = 0;

        //初始化
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (input[i][j] == 0) {
                    input[i][j] = 2;
                } else if (input[i][j] == 1) {
                    continue;
                } else {
                    input[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dp = new int[row][col];

        if (input[0][0] == Integer.MAX_VALUE)
            return -1;

        dp[0][0] = input[0][0];

        for (int i = 1; i < col; i++) {
            if (dp[0][i] == Integer.MAX_VALUE || dp[0][i-1] == Integer.MAX_VALUE) {
                dp[0][i] = Integer.MAX_VALUE;
            } else {
                dp[0][i] = dp[0][i-1] + input[0][i];
            }
        }

        for(int i =1;i< row;i++){
            if(dp[i][0] == Integer.MAX_VALUE || dp[i-1][0] == Integer.MAX_VALUE)
                dp[i][0] = Integer.MAX_VALUE;
            else
                dp[i][0] = dp[i-1][0] + input[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(input[i][j] == Integer.MAX_VALUE){
                    dp[i][j] = Integer.MAX_VALUE;
                }else {
                    if(dp[i-1][j] == Integer.MAX_VALUE && dp[i][j-1] == Integer.MAX_VALUE){
                        dp[i][j] = Integer.MAX_VALUE;
                    }else {
                        //右和下
                        dp[i][j] = Math.min(
                                dp[i-1][j],
                                dp[i][j-1]
                        )+ input[i][j];
                    }
                }
            }
        }
        if(dp[row-1][col-1] == Integer.MAX_VALUE)
            return -1;
        else
            return dp[row-1][col-1] - input[0][0];
    }

    public static void main(String[] args) {

    }
}
