package com.whut.algorithm.high.frequence.offer.problem_offer_29_shun_shi_zhen_da_yin_ju_zhen_lcof;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/6 16:44
 * @desription
 */
public class ShunShiZhenDaYinJuZhenLcof {

    /**
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     *
     * @param matrix
     * @return
     */
    public static int[] spiralOrder(int[][] matrix) {

        int row = matrix.length;

        if(row == 0)
            return new int[]{};

        int col = matrix[0].length;

        int[] result = new int[row * col];


        List<Integer> list = new ArrayList<>();

        boolean[][] visited = new boolean[row][col];

        /**
         *
         *  ---------->y
         *  \
         *  \
         *  \
         *  \
         *  x
         *
         */

        int[][] directions = new int[][]{
                {0, 1},//右
                {1, 0},//下
                {0, -1},//左
                {-1, 0}//上
        };

        //起点
        int x = 0;
        int y = 0;

        //控制方向
        int index = 0;
        int newX;
        int newY;


        for (; ; ) {
            //结束条件
            if (list.size() == row * col)
                break;

            //没有遍历过
            if (!visited[x][y]) {
                visited[x][y] = true;
                list.add(matrix[x][y]);
            } else {
                //回退
                x -= directions[index % 4][0];
                y -= directions[index % 4][1];
                //换方向
                index++;
            }

            newX = x + directions[index % 4][0];
            newY = y + directions[index % 4][1];

            if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                //换方向
                index++;
                newX = x + directions[index % 4][0];
                newY = y + directions[index % 4][1];
            }

            x = newX;
            y = newY;
        }

        for(int i=0;i<list.size();i++)
            result[i] = list.get(i);

        return result;
    }

    public static void main(String[] args) {
        int [][]matrix = new int[][]{};
        spiralOrder(matrix);
    }
}
