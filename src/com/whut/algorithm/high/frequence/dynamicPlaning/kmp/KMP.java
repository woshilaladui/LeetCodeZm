package com.whut.algorithm.high.frequence.dynamicPlaning.kmp;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/18 17:00
 * @desription
 */
public class KMP {

    private int[][] dp;
    private String part;

    /**
     * 状态机
     *
     * @param part
     */
    KMP(String part) {
        this.part = part;

        int M = part.length();

        //ascii 最大256
        dp = new int[M][256];

        //初始化
        //当遇到part.charAt(0) 向前推进，其余都不推进
        dp[0][part.charAt(0)] = 1;

        //影子状态，于状态 X 总是落后状态 j 一个状态，与 j 具有最长的相同前缀。所以我把 X 比喻为影子状态，似乎也有一点贴切。
        int X = 0;

        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {

                //向前推进
                if (part.charAt(j) == c)
                    dp[j][c] = j + 1;
                else
                    //询问影子回退
                    dp[j][c] = dp[X][c];
            }
            //更新影子状态
            X = dp[X][part.charAt(j)];
        }//end for
    }//end KMP

    public int search(String text) {
        int M = part.length();
        int N = text.length();
        int j = 0;
        for (int i = 0; i < N; i++) {
            //查询回退的状态机位置
            j = dp[j][text.charAt(i)];

            if (j == M)
                return i - M + 1;
        }

        return -1;
    }//end search

}

