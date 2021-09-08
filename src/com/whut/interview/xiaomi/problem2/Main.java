package com.whut.interview.xiaomi.problem2;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/8 19:35
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++)
            arr[i] = scanner.nextInt();
        int oneFlag = 0;
        int threeFlag = arr.length - 1;
        int index = 0;

        while (index < threeFlag) {
            if (arr[index] == 1) {
                swap(arr, index, oneFlag);
                oneFlag++;
                index++;
            } else if (arr[index] == 2) {
                index++;
            } else {//3
                swap(arr, index, threeFlag);
                threeFlag--;
            }
        }//end while
        for (int i = 0; i < arr.length - 1; i++)
            System.out.print(arr[i] + " ");
        System.out.println(arr[arr.length - 1]);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
