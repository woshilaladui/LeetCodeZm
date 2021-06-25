package com.whut.algorithm.high.frequence.offer.problem_offer_12_ju_zhen_zhong_de_lu_jing_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/25 8:50
 * @desription
 */
public class JuZhenZhongDeLuJingLcof {

    private static int[][] directions = new int[][]{
            {0, 1},//下
            {1, 0},//右
            {0, -1},//上
            {-1, 0}//左
    };


    public boolean exist(char[][] board, String word) {

        char[] arrayWord = word.toCharArray();

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //首字母相同开始回溯找
                if (board[i][j] == arrayWord[0]) {
                    boolean[][] visited = new boolean[row][col];

                    //标记起点访问过
                    visited[i][j] = true;
                    if (backTrack(i, j, board, arrayWord, visited, 1))
                        return true;
                }
            }
        }


        return false;
    }

    public boolean backTrack(
            int x,
            int y,
            char[][] board,
            char[] arrayWord,
            boolean[][] visited,
            int pos
    ) {

        //回溯结束条件
        if (pos == arrayWord.length)
            return true;

        //沿着4个方向
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];

            //判断是否越界
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length)
                continue;

            if(visited[newX][newY])
                continue;

            if (board[newX][newY] == arrayWord[pos]) {
                visited[newX][newY] = true;

                if (backTrack(newX, newY, board, arrayWord, visited, pos + 1))
                    return true;

                visited[newX][newY] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
