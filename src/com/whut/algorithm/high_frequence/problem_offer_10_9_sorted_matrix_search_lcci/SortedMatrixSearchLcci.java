package com.whut.algorithm.high_frequence.problem_offer_10_9_sorted_matrix_search_lcci;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/25 9:39
 * @desription
 */
public class SortedMatrixSearchLcci {

    /**
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0)
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            int num = matrix[row][col];

            if(num == target)
                return true;
            else if(num > target){
                col--;
            }else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
