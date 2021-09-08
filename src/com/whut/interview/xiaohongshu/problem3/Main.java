package com.whut.interview.xiaohongshu.problem3;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/4 11:00
 * @desription
 */
public class Main {
    static int[][] weight;
    static int N;

    private static int dfs(int u, int w, int k, int par) {
        int result = 0;
        for (int v = 1; v <= N; v++) {
            if (v != par && weight[u][v] != 0 && w + weight[u][v] <= k) {
                result++;
                result += dfs(v, w + weight[u][v], k, u);
            }
        }
        return result;
    }

    /**
     * 5 4
     * 1 2 3 1 3 1 1 4 2 3 5 1
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int k = scanner.nextInt();
        weight = new int[N + 1][N + 1];
        scanner.nextLine();
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");

        for (int i = 0; i < s1.length;) {
            int a = Integer.parseInt(s1[i++]);
            int b = Integer.parseInt(s1[i++]);
            int c = Integer.parseInt(s1[i++]);
            weight[a][b] = weight[b][a] = c;
        }
        int result = 0;

        for (int i = 1; i <= N; i++) {
            result += dfs(i, 0, k, i);
        }
        System.out.println(result / 2);

    }


}
