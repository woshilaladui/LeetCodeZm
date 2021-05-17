package com.whut.algorithm.dynamicPlaning.problem651_four_keyboard;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/4 16:44
 * @desription
 */
public class FourBoard {


    private static int maxA(int N) {

        //dp[i]代表
        int[] dp = new int[N + 1];

        //
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            //选择只输入A
            dp[i] = dp[i - 1] + 1;
            //输入c+v
            //从j开始ctrl + v
            for (int j = 2; j < i; j++) {
                // 全选 & 复制 dp[j-2]，连续粘贴 i - j 次
                // 屏幕上共 dp[j - 2] * (i - j + 1) 个 A
                dp[i] = Math.max(
                        dp[i],
                        dp[j - 2] * (i - j + 1)
                );
            }
        }

        return dp[N];
    }

    public static void main(String[] args) {
        int N = 7;
        System.out.println(maxA(N));
    }

}
