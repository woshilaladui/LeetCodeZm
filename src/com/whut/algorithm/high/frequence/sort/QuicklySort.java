package com.whut.algorithm.high.frequence.sort;

import java.util.Random;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/1 19:59
 * @desription
 */
public class QuicklySort {

    public static int parition(int[] A, int low, int high) {

        int pivotKey = A[low];

        while (low < high) {
            //从右边调整
            while (low < high && A[high] >= pivotKey)
                high--;

            A[low] = A[high];

            while (low < high && A[low] <= pivotKey)
                low++;

            A[high] = A[low];
        }//end while

        //将枢轴归位
        A[low] = pivotKey;


        return low;

    }

    public static void quicklySort(int[] A, int low, int high) {
        if (low <= high) {
            int pivotLoc = parition(A, low, high);
            quicklySort(A, low, pivotLoc - 1);
            quicklySort(A, pivotLoc + 1, high);
        }
    }

    public static void main(String[] args) {
        int []A = new int[]{53,17,78,4,45,65,87,32};

        quicklySort(A,0,A.length-1);

        for (int i : A) {
            System.out.print(i+" ");
        }

    }
}
