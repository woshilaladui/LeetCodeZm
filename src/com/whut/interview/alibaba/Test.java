package com.whut.interview.alibaba;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/19 18:58
 * @desription
 */
public class Test {

    /**
     * 寻找3个递增的数字
     * @param A
     * @param a
     * @param b
     * @param p
     */
    private static void f(int[] A, int[] a, int[] b, int p) {
        //数组长度为3
        int n = a.length;

        int temp1 = a[p];
        int temp2 = Integer.MAX_VALUE;
        int temp3 = Integer.MAX_VALUE;


        int i = p, j = 0, k = 0;
        //p = 1;

        for (int index = p +1; index < n; index++) {
            if (a[index] >= temp1 && temp2 == Integer.MAX_VALUE) {
                temp2 = a[index];
                j = index;

            } else if (a[index] >= temp2 && temp3 == Integer.MAX_VALUE) {
                temp3 = a[index];
                k = index;
            }


        }

        A[0] = temp1;
        A[1] = temp2;
        A[2] = temp3;

        A[3] = i;
        A[4] = j;
        A[5] = k;

    }

    private static int getMin() {

        int i, j, k;

        int []A = new int[6];


        int[] a = new int[]{9, 8, 6, 7, 7, 2, 9, 2};
        int[] b = new int[]{9, 1, 10, 8, 6, 4, 8, 6};

        /**
         *
         * 8
         * 9 8 6 7 7 2 9 2
         * 9 1 10 8 6 4 8 6
         *
         */

        //第一步排序 对a 数组相等的位置，按照b递减排序
        int n = a.length;

        int result = Integer.MAX_VALUE;

        for (int p = 0; p < n; p++) {
            f(A,a,b,p);

            if(A[0] != Integer.MAX_VALUE && A[1] != Integer.MAX_VALUE && A[2] != Integer.MAX_VALUE){

                result = Math.min(result,b[A[3]] + b[A[4]] + b[A[5]]);
            }
        }

        //f(a, a, a, 2);

        System.out.println(result);

        return result;
    }

    public static void main(String[] args) {
        getMin();
    }
}
