package com.whut.algorithm.high_frequence.problem79_word_search;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/30 19:22
 * @desription
 */
public class WordSearch {

    private static int[][] directions = new int[][]{
            {0, 1},//下
            {1, 0},//右
            {0, -1},//上
            {-1, 0}//左
    };

    private static boolean[][] visited;

    public static boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;

        char[] c_word = word.toCharArray();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == c_word[0]) {
                    visited = new boolean[row][col];

                    //标记起点访问过
                    visited[i][j] = true;
                    if (backTrack(i, j, c_word, board, 1)) {
                        return true;
                    }

                }
            }
        }

        return false;
    }

    /**
     * @param x      x轴坐标
     * @param y      y轴坐标
     * @param c_word 目标字符串数组
     * @param board  棋盘
     * @param pos    目标字符串数组下标
     * @return
     */
    private static boolean backTrack(int x, int y, char[] c_word, char[][] board, int pos) {

        if (pos == c_word.length)
            return true;

        //遍历4个方向
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];

            //检测是否越界
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length)
                continue;

            if (visited[newX][newY])
                continue;

            //回溯
            if (board[newX][newY] == c_word[pos]) {
                visited[newX][newY] = true;

                if (backTrack(newX, newY, c_word, board, pos + 1)) {
                    return true;
                }

                visited[newX][newY] = false;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        String word = "ABCB";
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(board,word));
    }
}
