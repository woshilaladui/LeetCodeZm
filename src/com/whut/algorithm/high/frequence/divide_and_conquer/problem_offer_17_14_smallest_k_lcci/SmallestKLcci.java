package com.whut.algorithm.high.frequence.divide_and_conquer.problem_offer_17_14_smallest_k_lcci;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/24 13:54
 * @desription
 */
public class SmallestKLcci {


    public static int[] smallestK(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i =0;i<arr.length;i++){
            queue.add(arr[i]);
        }

        int []result = new int[k];

        for(int i =0;i<k;i++){
            result[i] = queue.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int []arr = new int[]{1,3,5,7,2,4,6,8};

        int []result = smallestK(arr,4);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
}
