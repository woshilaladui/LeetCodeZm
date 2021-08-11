package com.whut.algorithm.high.frequence.offer.problem_offer_63_gu_piao_de_zui_da_li_run_lcof;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/10 21:39
 * @desription
 */
public class GuPiaoDeZuiDaLiRunLcof {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0)
            return 0;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                // 解释：
                //   dp[i][0]
                // = max(dp[-1][0], dp[-1][1] + prices[i])
                // = max(0, -infinity + prices[i]) = 0
                dp[i][1] = -prices[i];
                //解释：
                //   dp[i][1]
                // = max(dp[-1][1], dp[-1][0] - prices[i])
                // = max(-infinity, 0 - prices[i])
                // = -prices[i]
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
//        Integer []a = new Integer[]{1,2,3};

        Integer []arr = new Integer[]{3,2,1,1,2};


       // arr = Arrays.stream(a).mapToInt(Integer::intValue).toArray();


//        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
//        int[] result = new int[set.size()];
//        int i = 0;
//
//        for (int a : set) {
//            result[i++] = a;
//        }
//
//        for (int i1 : result) {
//            System.out.print(i1+" ");
//        }
        Set<Integer> set = new LinkedHashSet<>();
        for (int a : arr) {
            set.add(a);
        }

        int[] result = new int[set.size()];
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            result[i++] = (int)it.next();
        }

        for (int i1 : result) {
            System.out.println(i1+" ");
        }

        System.out.println("----------");
        String str1=null;
        String str2=null;
        String str3=str1+str2;
        System.out.println(str3);

    }
}
