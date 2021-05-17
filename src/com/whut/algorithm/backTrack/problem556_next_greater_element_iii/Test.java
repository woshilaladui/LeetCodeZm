package com.whut.algorithm.backTrack.problem556_next_greater_element_iii;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/3 10:24
 * @desription
 */
public class Test {

    private static int nextGreater(int[] A) {

        int n = A.length;

        int i = n - 2;

        //从后面往前面扫描第一个递减序列
        while (i > -1 && A[i + 1] <= A[i])
            i--;

        //然后从后往前找到第一个比这个数字大的数字
        int j = n - 1;

        while (j > -1 && A[j] < A[i])
            j--;

        //交换顺序
        int temp = A[j];
        A[j] = A[i];
        A[i] = temp;

        //逆序i+1 -- length -1

        //System.out.println(A[i] + " " + A[j]);
        reverse(i+1,n-1,A);

        for (int i1 : A) {
            System.out.print(i1);
        }

        return -1;
    }

    private static void reverse(int i, int j,int []A) {
        while (i < j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;

            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        //nextGreater(new int[]{2, 4, 6, 7, 3, 1});

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.addFirst(4);

        System.out.println(linkedList.getLast());

    }
}
