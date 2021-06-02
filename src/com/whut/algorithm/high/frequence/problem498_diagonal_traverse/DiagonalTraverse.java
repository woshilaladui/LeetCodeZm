package com.whut.algorithm.high.frequence.problem498_diagonal_traverse;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/11 10:26
 * @desription
 */
public class DiagonalTraverse {

    /**
     * 1(0,0)   2(0,1)  3(0,2)
     * 4(1,0)   5(1,1)  6(1,2)
     * 7(2,0)   8(2,1)  9(2,2)
     * <p>
     * 第一趟: 1        起始坐标 x + y = 0
     * 第二趟  2 4      起始坐标 x + y = 1   x++,y--
     * 第三天  7,5,3    起始坐标 x + y = 2   x-- ,y++
     *
     * @param mat
     * @return
     */
    public static int[] findDiagonalOrder(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;

        //总趟数
        int n = row + col - 1;

        int[] result = new int[row * col];

        int i = 0;//趟号

        int k = 0;

        while (i < n) {

            //1 3 5 ..趟
            //确定起始坐标
            int x1 = i < row ? i : row - 1;
            int y1 = i - x1;
            while (x1 >= 0 && y1 < col) {

                result[k++] = mat[x1][y1];
                x1--;
                y1++;
            }

            i++;

            if (i >= n)
                break;

            int y2 = i < col ? i : col - 1;
            int x2 = i - y2;
            while (x2 < row && y2 >= 0) {

                result[k++] = mat[x2][y2];

                x2++;
                y2--;
            }
            //2 4 6 ...趟
            i++;
        }


        return result;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] mat = new int[][]{{1,2},{3,4}};

        int[] result = findDiagonalOrder(mat);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
