package com.whut.interview;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/2 19:33
 * @desription
 */
public class Test {

    private static int f(int[] A) {

        int n = A.length;

        int result = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (A[i] > A[j]) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    break;
                }
            }
            result = reverse(A);

        }

        return result;
    }

    private static int reverse(int[] A) {
        return -1;
    }

    public static void main(String[] args) {

    }
}
