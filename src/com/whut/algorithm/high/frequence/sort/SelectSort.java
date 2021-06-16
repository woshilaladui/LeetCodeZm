package com.whut.algorithm.high.frequence.sort;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/1 20:41
 * @desription
 */
public class SelectSort {

    public static void selectSort(int[] A) {
        int n = A.length;

        for (int i = 0; i < n; i++) {
            //k用于记录最小追
            int k = i;

            for (int j = i + 1; j < n; j++) {
                //寻找最小值
                if (A[k] > A[j])
                    k = j;
            }
            //此时k为最小值
            int temp = A[k];
            A[k] = A[i];
            A[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{53, 17, 78, 4, 45, 65, 87, 32};

        selectSort(A);

        for (int i : A) {
            System.out.print(i + " ");
        }

    }
}
