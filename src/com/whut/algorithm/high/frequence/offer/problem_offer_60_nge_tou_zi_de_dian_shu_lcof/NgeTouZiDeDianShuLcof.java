package com.whut.algorithm.high.frequence.offer.problem_offer_60_nge_tou_zi_de_dian_shu_lcof;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/6 21:32
 * @desription
 */
public class NgeTouZiDeDianShuLcof {
    public double[] dicesProbability(int n) {
        // getCount(2,4)代表2个筛子 摇出4的次数
        //getCount(2,4) = getCount(1,1) + getCount(1,2) + getCount(1,3)

        int[][] dp = new int[12][72];

        //dp[i][j] 代表i个筛子，摇出j的次数
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            //点数遍历
            for (int j = i; j <= 6 * i; j++) {
                //当前点数
                for (int cur = 1; cur <= 6; cur++) {
                    //不可能出现的情况
                    if (j - cur <= 0)
                        break;

                    dp[i][j] += dp[i - 1][j - cur];
                }
            }
        }//end for

        int all = (int) Math.pow(6, n);

        List<Double> list = new ArrayList<>();

        for (int i = n; i <= 6 * n; i++)
            list.add(dp[n][i] * 1.0 / all);


        double[] result = new double[5 * n + 1];

        for (int i = 0; i < 5 * n + 1; i++)
            result[i] = list.get(i);

        return result;

    }

    public static void main(String[] args) {

    }
}
