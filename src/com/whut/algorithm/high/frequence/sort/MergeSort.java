package com.whut.algorithm.high.frequence.sort;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/1 20:13
 * @desription
 */
public class MergeSort {

    /**
     * O(nlogn)
     *
     * 稳定排序
     */

    private static int result = 0;

    /**
     *
     * @param A
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] A, int low, int mid, int high) {

        int i, j, k;

        //将A复制到一个新的数组中
        int[] B = new int[A.length];

        if (high + 1 - low >= 0) System.arraycopy(A, low, B, low, high + 1 - low);

        for (i = low, j = mid + 1, k = low; i <= mid && j <= high; k++) {
            if (B[i] <= B[j]) {
                result += (high - j + 1) * B[i];
                A[k] = B[i++];
            } else
                A[k] = B[j++];
        }

        //处理没有处理完的
        while (i <= mid)
            A[k++] = B[i++];

        while (j <= high)
            A[k++] = B[j++];
    }

    /**
     *
     * 归并[low,high] 闭区间
     *
     * @param A
     * @param low
     * @param high
     */
    public static void mergeSort(int[] A, int low, int high) {
        //  if (low < high) {

        if (low == high)
            return;
        int mid = (low + high) / 2;

        mergeSort(A, low, mid);
        mergeSort(A, mid + 1, high);
        merge(A, low, mid, high);
        //  }
    }

    public static void main(String[] args) {
        int[] A = new int[]{7,5,6,4};

        mergeSort(A, 0, A.length - 1);

        for (int i : A) {
            System.out.print(i + " ");
        }

        System.out.println("result = " + result);
    }
}
