package com.whut.interview.alibaba.feizu.interview;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/29 11:06
 * @desription
 */
public class Main1 {
    public static void main(String[] args) {
        //yujwedjhccdskdsewirewrwsadm,fnsdklwweqpq
        String str = "ujwedjhccdskdsewirewrwsadm,fnsdklwweqpq";

        String[] arrStr = str.split("w");

        StringBuilder sb = new StringBuilder();

        if (str.charAt(0) == 'w')
            sb.append(arrStr[0]);

        if (str.charAt(str.length() - 1) == 'w')
            sb.append(arrStr[arrStr.length - 1]);

        for (int i = 1; i < arrStr.length - 1; i++) {
            sb.append(arrStr[i]);
        }

        char[] arr = sb.toString().toCharArray();

        mergeSort(arr, 0, arr.length - 1);

        for (char c : arr) {
            System.out.print(c);
        }

    }

    public static void merge(char[] arrStr, int low, int mid, int high) {

        char[] tempStr = new char[arrStr.length];

        for (int i = low; i <= high; i++) {
            tempStr[i] = arrStr[i];
        }

        int i, j, k;

        for (i = low, k = low, j = mid + 1; i <= mid && j <= high; k++) {
            if (tempStr[i] < tempStr[j]) {
                arrStr[k] = tempStr[i++];
            } else {
                arrStr[k] = tempStr[j++];
            }
        }

        while (i <= mid) {
            arrStr[k++] = tempStr[i++];
        }

        while (j <= high) {
            arrStr[k++] = tempStr[j++];
        }

    }


    public static void mergeSort(char[] arrStr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arrStr, left, mid);
            mergeSort(arrStr, mid + 1, right);
            merge(arrStr, left, mid, right);
        }
    }
}
