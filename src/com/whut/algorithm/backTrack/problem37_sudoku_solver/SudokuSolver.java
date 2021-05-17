package com.whut.algorithm.backTrack.problem37_sudoku_solver;

import java.util.HashMap;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/30 15:35
 * @desription
 */
public class SudokuSolver {


    public static void solveSudoku(char[][] board) {
        backTrack(board, 0, 0);

//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }

    }

    private static boolean backTrack(char[][] board, int i, int j) {
        int n = 9, m = 9;

        //本行遍历完了
        if (j == n) {
            return backTrack(board, i + 1, 0);

        }

        if (i == m)
            return true;

        //是数字不需要处理
        if (board[i][j] != '.') {
            return backTrack(board, i, j + 1);

        }

        for (char ch = '1'; ch <= '9'; ch++) {
            if (!isValid(board, i, j, ch))
                continue;

            board[i][j] = ch;
            if (backTrack(board, i, j + 1))
                return true;
            board[i][j] = '.';
        }

        //穷举玩了1-9，依然没有找到可行的解
        //需要前面数字换一下
        return false;
    }

    private static boolean isValid(char[][] board, int row, int column, char n) {
        for (int i = 0; i < 9; i++) {
            //判断行是否存在该数字
            if (board[i][column] == n)
                return false;
            //判断列是否存在该数字
            if (board[row][i] == n)
                return false;

            //判断3*3
            if (board[(row / 3) * 3 + i / 3][(column / 3) * 3 + i % 3] == n)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//                {'.','8','7','6','5','4','3','2','1'},
//                {'2','.','.','.','.','.','.','.','.'},
//                {'3','.','.','.','.','.','.','.','.'},
//                {'4','.','.','.','.','.','.','.','.'},
//                {'5','.','.','.','.','.','.','.','.'},
//                {'6','.','.','.','.','.','.','.','.'},
//                {'7','.','.','.','.','.','.','.','.'},
//                {'8','.','.','.','.','.','.','.','.'},
//                {'9','.','.','.','.','.','.','.','.'}

        };

        solveSudoku(board);

    }
}
