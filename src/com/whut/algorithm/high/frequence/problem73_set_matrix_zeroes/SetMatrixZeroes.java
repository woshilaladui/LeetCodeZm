package com.whut.algorithm.high.frequence.problem73_set_matrix_zeroes;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/16 19:48
 * @desription
 */
public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        Set<Integer> rowSet = new HashSet<>();

        Set<Integer> colSet = new HashSet<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        //置为0
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(rowSet.contains(i) || colSet.contains(j))
                    matrix[i][j] = 0;
            }
        }

    }

    public static void main(String[] args) {

    }
}
