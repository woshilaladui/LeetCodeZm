package com.whut.algorithm.high_frequence.problem_offer4_er_wei_shu_zu_zhong_de_cha_zhao_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/20 21:11
 * @desription
 */
public class ErWeiShuZuZhongDeChaZhaoLcof {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int row = 0, column = columns - 1;

        while (row < rows && column >= 0) {

            int num = matrix[row][column];

            if (num == target)
                return true;
            else if (num > target)
                column--;
            else
                row++;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
