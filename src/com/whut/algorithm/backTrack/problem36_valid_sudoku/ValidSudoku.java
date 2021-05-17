package com.whut.algorithm.backTrack.problem36_valid_sudoku;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/30 16:50
 * @desription
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                if(board[i][j] == '.')
                    continue;
                if(isValid(board,i,j,board[i][j]))
                    continue;

                return false;
            }
        }


        return true;
    }

    private static boolean isValid(char[][] board, int row, int column, char n) {
        for (int i = 0; i < 9; i++) {
            //检查列
            if(board[row][i] == n && i!= column)
                return false;
            //检查行
            if(board[i][column] == n && i!=row)
                return false;

            //检查3*3的方格
            int tempR = (row/3)*3 + i/3;
            int tempC = (column/3)*3 + i%3;
            if(board[tempR][tempC] == n && (tempR!=row&&tempC!=column))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
