package com.whut.algorithm.sort;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/1 20:58
 * @desription
 */
public class ShellSort {

    public static void shellSort(int[] A) {
        int dk, i, j, k;
        int n = A.length;
        for (dk = n / 2; dk >= 1; dk /= 2) {
            for (i = dk; i < n; i++) {
                if (A[i - dk] > A[i]) {
                    int temp = A[i];

                    for (j = i - dk; j >= 0 && temp < A[j]; j-=dk)
                        A[j+dk] = A[j];

                    A[j+dk] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{53, 17, 78, 4, 45, 65, 87, 32};

        shellSort(A);

        for (int i : A) {
            System.out.print(i + " ");
        }
    }
}
