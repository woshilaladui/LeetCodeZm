package com.whut.interview.jingdong.problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/11 19:42
 * @desription
 */
public class Main {
    public static void main(String[] args) {

    }

    private static int[][] directions = new int[][]{
            {0, 1},//右
            {1, 0},//下
            {0, -1},//左
            {-1, 0}//上
    };
    private static int min = Integer.MAX_VALUE;

    public int movingCount(int m, int n, int moveCost, int reverseCost, int downCost) {

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        List<String> list = new ArrayList<>();


        return list.size() + 1;
    }

    private static void backTrack(char[][] arr, String str, int index, int sum,boolean [][]vis ,int x, int y, int z) {
        if (index == str.length()) {
            min = Math.min(
                    min, sum
            );
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];

            //判断是否越界
            if (newX < 0 || newX >= arr.length || newY < 0 || newY >= arr[0].length)
                continue;

            if(vis[newX][newY])
                continue;


        }


    }

    private static int getMinTime(char[][] arr) {
        return 0;
    }
}
