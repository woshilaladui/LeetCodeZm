package com.whut.algorithm.high.frequence.dynamicPlaning.sub_string.problem1027_longest_arithmetic_subsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/8 16:46
 * @desription 和leetcode 300 类式，多了一个维度来维护diff 公差选项
 */
public class LongestArithmeticSubsequence {

    /**
     * 和leetcode 873 最长的斐波那契子序列的长度 定义的动态规划一样
     *
     * @param A
     * @return
     */
    private static int longestArithSeqLength1(int[] A) {

        int n = A.length;

        /**
         *
         * dp[i][j]  代表以A[i],A[j] 结尾的最长等差数列的长度 ，默认值为2
         *
         * 寻找k 使得 A[i] + (A[i] -A[k]) = A[j]   -> A[k] = 2*A[i] -A[j]
         *
         * dp[i][j] = max(dp[i][j],dp[k][i]+1)
         *
         */
        int[][] dp = new int[n][n];

        //base case
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
                dp[i][j] = 2;
        }


        /**
         *
         *   for (int i = 0; i < n; i ++) {
         *             for (int j = i + 1; j < n; j ++) {
         *                 int target = 2 * A[i] - A[j];
         *                 for (int k = i - 1; k >= 0; k --) {
         *                     if (A[k] == target) {
         *                         dp[i][j] = dp[k][i] + 1;
         *                         break;
         *                     }
         *                 }
         *                 ans = max(ans, dp[i][j]);
         *             }
         *         }
         *
         *
         * 三重循环会超时，所以用map来记录A[k]  k的位置
         *
         *
         */

        Map<Integer, Integer> map = new HashMap<>();

        /**
         * 此题有重复元素，所以只能一边遍历一边给hash字典填加
         * 这样是错的,后面相同元素会覆盖前面元素
         */
//        for(int i=0;i<n;i++)
//            map.put(A[i],i);

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int arrK = 2*A[i] - A[j];

                if(map.containsKey(arrK)){
                    int k = map.get(arrK);
                    if(k<i){
                        //k < i< j

                        dp[i][j] = Math.max(dp[i][j],dp[k][i]+1);

                    }

                }
                maxLen = Math.max(maxLen,dp[i][j]);
            }

            //注意为什么map要在循环完之后，因为可能发生 24 24 24 这种情况
            map.put(A[i],i);

        }


        return maxLen;
    }

    private static int longestArithSeqLength(int[] A) {

        if (A.length == 0)
            return 0;

        int n = A.length;

        int[][] dp = new int[n][20001];

        int diff;
        int offset = 10000;//偏移量
        int max_length = 1;
        //初始化
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //因为公差可能为负数
                diff = A[i] - A[j];
                diff += offset;
                dp[i][diff] = dp[j][diff] + 1;
                max_length = Math.max(max_length, dp[i][diff]);
                //dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                //max_length = Math.max(dp[i][diff], max_length);

            }

        }

        return max_length;
    }

    public static void main(String[] args) {

        //int[] A = new int[]{44,46,22,68,45,66,43,9,37,30,50,67,32,47,44,11,15,4,11,6,20,64,54,54,61,63,23,43,3,12,51,61,16,57,14,12,55,17,18,25,19,28,45,56,29,39,52,8,1,21,17,21,23,70,51,61,21,52,25,28};

        int[] A  = new int[]{83,20,17,43,52,78,68,45};




        System.out.println(longestArithSeqLength1(A));
    }

}
