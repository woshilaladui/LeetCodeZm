package com.whut.algorithm.high.frequence.problem54_spiral_matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/9 10:07
 * @desription
 */
public class SpiralMatrix {


    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        int direcation[][] = new int[][]{
                {0, 1},//右
                {1, 0},//下
                {0, -1},//左
                {-1, 0}//上

        };

        int[][] visited = new int[row][col];

        int x = 0;
        int y = 0;
        int k = 0;
        int newX;
        int newY;

        for (; ; ) {

            if (result.size() == row * col)
                break;

            //没有被访问过
            if (visited[x][y] == 0) {
                result.add(matrix[x][y]);
                visited[x][y] = 1;
            } else {
                //回溯
                x -= direcation[k % 4][0];
                y -= direcation[k % 4][1];
                k++;
            }

            //判断是否越界
            newX = x + direcation[k % 4][0];
            newY = y + direcation[k % 4][1];

            if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                k++;
                newX = x + direcation[k % 4][0];
                newY = y + direcation[k % 4][1];
            }

            x = newX;
            y = newY;

        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> list = spiralOrder(matrix);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
