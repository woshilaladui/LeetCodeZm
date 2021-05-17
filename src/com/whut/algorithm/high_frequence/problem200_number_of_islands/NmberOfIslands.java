package com.whut.algorithm.high_frequence.problem200_number_of_islands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/30 20:20
 * @desription
 */
public class NmberOfIslands {
    public static int numIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int num = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }

        return num;
    }

    /**
     * bfs
     *
     * @param grid
     * @return
     */
    private static int numIslands2(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int num = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    grid[i][j] = '0';

                    Queue<Integer> queue = new LinkedList<>();

                    queue.add(i * grid[0].length + j);

                    while (!queue.isEmpty()) {
                        int id = queue.poll();

                        int x = id / col;
                        int y = id % col;

                        //遍历4个方向
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            queue.add((x - 1) * col + y);
                            grid[x - 1][y] = '0';
                        }

                        if (x + 1 < row && grid[x + 1][y] == '1') {
                            queue.add((x + 1) * col + y);
                            grid[x + 1][y] = '0';
                        }

                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            queue.add(x * col + y - 1);
                            grid[x][y - 1] = '0';
                        }

                        if (y + 1 < col && grid[x][y + 1] == '1') {
                            queue.add(x * col + y + 1);
                            grid[x][y + 1] = '0';
                        }

                    }
                }
            }
        }

        return num;
    }

    private static void dfs(char[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;

        //判断是否越界
        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == '0')
            return;

        //每次遍历到 grid[x][y] = 1时候需要把 其置为0
        /**
         *
         * 1 1 0 0 0
         * 1 1 1 0 0
         * 0 0 1 0 0
         * 0 0 0 1 1
         *
         */
        grid[x][y] = '0';

        //遍历4个方向
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);

    }

    public static void main(String[] args) {


        //numIslands
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };


        System.out.println(numIslands2(grid));
    }
}
