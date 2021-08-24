package com.whut.algorithm.high.frequence.sort.train;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/24 14:33
 * @desription
 */
public class Main {

    public static void mergeSort(char[] arr, int low, int high) {
        if (low == high)
            return;
        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(char[] arr, int low, int mid, int high) {

        char[] temp = new char[arr.length];

        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }

        int i, j, k;

        for (i = low, j = mid + 1, k = low; i <= mid && j <= high; k++) {
            if (compareTo(temp[i], temp[j])) {
                arr[k] = temp[i++];
            } else {
                arr[k] = temp[j++];
            }
        }

        while (i <= mid)
            arr[k++] = temp[i++];

        while (j <= high)
            arr[k++] = temp[j++];

    }

    public static boolean compareTo(char a, char b) {
        //a < b return true
        //数字放中间

        if (Character.isDigit(a)) {
            if ('A' <= b && b <= 'Z') {
                return b - a <= 0;
            }
            return a - b <= 0;
        }

        if(Character.isDigit(b)){
            if ('A' <= a && a <= 'Z') {
                return b - a <= 0;
            }
            return a - b <= 0;
        }


        return a - b <= 0;
    }

    public static void main(String[] args) {
        String str = "dGf234sgdgDSF34b";
//        String str = "bdea";

        char[] arr = str.toCharArray();

        mergeSort(arr, 0, arr.length - 1);

        for (char c : arr) {
            System.out.print(c);
        }


    }
}
