package com.whut.interview.pdd.num2.problem2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/31 20:08
 * @desription
 */
public class Main {
    public static void main(String[] args) {

        System.out.println(compoareTo("abcdepf","abcde"));
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        String[] strs = new String[N];

        for (int i = 0; i < N; i++) {
            strs[i] = scanner.next();
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {

                char[] aArr = a.toCharArray();
                char[] bArr = b.toCharArray();

                int aLen = a.length();
                int bLen = b.length();

                int indexA = 0;
                int indexB = 0;

                int flag = 1;

                while (indexA < aLen && indexB < bLen) {
                    if (aArr[indexA] > aArr[aLen - indexA - 1] && indexA < aLen/2) {
                        //交换
                        swap(aArr, indexA, aLen - indexA - 1);
                    }

                    if (bArr[indexB] > bArr[bLen - indexB - 1] && indexB < bLen/2) {
                        swap(bArr, indexB, bLen - indexB - 1);
                    }

                    if (aArr[indexA] > bArr[indexB]) {
                        return 1;
                    } else if (aArr[indexA] < bArr[indexB]) {
                        return -1;
                    } else {
                        indexA++;
                        indexB++;
                    }

                }

                return aLen == bLen ? 0 : -1;
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(strs[i]);
        }

        /**
         * abcdeaf
         * abcde
         */
    }


    private static int compoareTo(String a, String b) {


        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        int aLen = a.length();
        int bLen = b.length();

        int indexA = 0;
        int indexB = 0;

        int flag = 1;

        while (indexA < aLen && indexB < bLen) {
            if (aArr[indexA] > aArr[aLen - indexA - 1]) {
                //交换
                swap(aArr, indexA, aLen - indexA - 1);
            }

            if (bArr[indexB] > bArr[bLen - indexB - 1]) {
                swap(bArr, indexB, bLen - indexB - 1);
            }

            if (aArr[indexA] > bArr[indexB]) {
                return 1;
            } else if (aArr[indexA] < bArr[indexB]) {
                return -1;
            } else {
                indexA++;
                indexB++;
            }

        }

        return aLen == bLen ? 0 : -1;
    }

    private static void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
