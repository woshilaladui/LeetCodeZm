package com.whut.algorithm.high.frequence.dynamicPlaning.bag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/1 13:10
 * @desription
 */
public class Test {

    public static void main(String[] args) {

        // System.out.println(quickm(2, 10));

//        int n = 3;
//        int m = 2;
//
//        int[][] cv = new int[][]{
//                {1, 1},
//                {1, 10},
//                {3, 1}
//        };
//
//        System.out.println(bag(n, m, cv));


//        int n = 5;
//        int m = 3;
//        int[][] a = new int[][]{
//                {2, 11, 21},
//                {19, 10, 1},
//                {20, 11, 1},
//                {6, 15, 24},
//                {18, 27, 36}
//        };
//
//        System.out.println(f(n, m, a));

        int n = 4;

        int [][]xy = new int[][]{
                {1,2},
                {3,4},
                {5,6},
                {1,6}
        };

        System.out.println(f2(n,xy));

        for(int i = 0;i<=6;i++)
            System.out.println(V[i]);
    }

    public static int[] V = new int[1024];


    public static int getRoot(int a) {
        while (a != V[a]) {
            a = V[a];
        }
        return a;
    }

    public static int f2(int n, int[][] xy) {

        int x, y;
        Set<Integer> set = new HashSet<>();

        int maxPerson = 1;

        //初始化
        for (int i = 0; i < n; i++) {
            x = xy[i][0];
            V[x] = x;
            if (maxPerson < x)
                maxPerson = x;
            y = xy[i][1];
            V[y] = y;
            if (maxPerson < y)
                maxPerson = y;

            set.add(x);
            set.add(y);
        }

        for (int i = 0; i < n; i++) {
            x = getRoot(xy[i][0]);
            y = getRoot(xy[i][1]);

            if (x != y) {
                V[x] = y;
            }
        }


        //统计
        int maxValue = 0;


        for (Integer value : set) {
            int cnt = 0;
            for (int i = 1; i < value; i++)
                if (getRoot(i) == value) {
                    cnt++;

                }

            if (maxValue < cnt)
                maxValue = cnt;

        }

        return maxValue;
    }

    public static int f(int n, int m, int[][] a) {
        List<Integer> list = new ArrayList<>();

        int cnt = 0;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                sum = a[i][j] - a[i][0];

                list.add(-sum);
            }

            if (list.contains(sum))
                cnt++;

            list.add(sum);
        }
        return cnt;
    }

    public static int bag(int n, int m, int[][] cv) {

        int[] dp = new int[m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                if (j >= cv[i][0]) {
                    //dp[i][j] = max(dp[i-1][j],dp[i-1][j-weight[i]] + value[i])
                    dp[j] = Math.max(dp[j], dp[j - cv[i][0]] + cv[i][1]);
                }
            }
        }

        return dp[m];
    }

    public static long quickm(int m, int n) {

        if (1 == m || 0 == n)
            return 1;

        if (1 == n)
            return m;

        long res = 1;

        while (n > 0) {
            if ((1 & n) != 0) {
                res *= m;
            }

            m *= m;
            n >>= 1;
        }


        return res;
    }

}
