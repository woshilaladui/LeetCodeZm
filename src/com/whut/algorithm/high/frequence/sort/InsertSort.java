package com.whut.algorithm.high.frequence.sort;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/1 20:49
 * @desription
 */
public class InsertSort {


    /**
     * O(n2)
     *
     * 稳定排休
     *
     * @param A
     * @param n
     */
    public static void insertSort(int[] A, int n) {
        int i, j;
        for (i = 1; i < n; i++) {
            /**
             * i为无序序列第一个数字
             * i-1为有序序列的最后一个数字
             */
            if (A[i - 1] > A[i]) {
                //需要排序
                int temp = A[i];

                //寻找插入位置
                for (j = i - 1; j >= 0 && temp < A[j]; j--)
                    //将数字后移
                    A[j + 1] = A[j];

                A[j + 1] = temp;
            }//end if
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{53, 17, 78, 4, 45, 65, 87, 32};
        insertSort(A, A.length);

        for (int i : A) {
            System.out.print(i + " ");
        }
    }
}
