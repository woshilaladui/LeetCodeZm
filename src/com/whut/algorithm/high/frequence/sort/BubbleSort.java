package com.whut.algorithm.high.frequence.sort;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/1 20:35
 * @desription
 */
public class BubbleSort {

    /**
     * O(n2)
     *
     * 稳定排序
     *
     * @param A
     * @param n
     */
    public static void bubbleSort(int[] A, int n) {
        boolean flag;
        for (int i = 0; i < n - 1; i++) {
            flag = false;
            for (int j = n - 1; j > i; j--) {
                if (A[j - 1] > A[j]) {
                    int temp = A[j - 1];
                    A[j - 1] = A[j];
                    A[j] = temp;
                    flag = true;
                }
            }
            if (!flag)
                return;
        }//end for
    }

    public static void main(String[] args) {
        int[] A = new int[]{53, 17, 78, 4, 45, 65, 87, 32};
        bubbleSort(A, A.length);

        for (int i : A) {
            System.out.print(i + " ");
        }
    }
}
