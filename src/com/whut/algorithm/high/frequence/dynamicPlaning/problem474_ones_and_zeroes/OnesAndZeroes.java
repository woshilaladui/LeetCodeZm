package com.whut.algorithm.high.frequence.dynamicPlaning.problem474_ones_and_zeroes;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/1 16:31
 * @desription
 */
public class OnesAndZeroes {

    /**
     * 采用二维数组压缩 （不能继续压缩）
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public static int findMaxForm(String[] strs, int m, int n) {

        if (strs == null || strs.length == 0)
            return 0;

        int[][] dp = new int[m + 1][n + 1];

        //初始化
        //都为0

        for (int i = 0; i < strs.length; i++) {
            int one = 0, zero = 0;
            //统计0/1出现的次数
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0')
                    zero++;
                else
                    one++;
            }

            //本来是三层dp[][][],压缩程成2层，并且类似于0/1背包，不可以重复拿，所以重后往前
            /**
             *
             */
            for(int j=m;j>=zero;j--)
                for(int k=n;k>=one;k--)
                    //dp[i][j][k] = Math.max(dp[i][j][k],dp[i-1][j-zero][k-one]+1)
                    dp[j][k] = Math.max(dp[j][k],dp[j-zero][k-one]+1);
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        int m=5,n =3;
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};

        System.out.println(findMaxForm(strs,m,n));

    }
}
