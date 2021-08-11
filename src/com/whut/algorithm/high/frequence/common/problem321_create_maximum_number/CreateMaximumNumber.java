package com.whut.algorithm.high.frequence.common.problem321_create_maximum_number;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/11 16:01
 * @desription
 */
public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] maxSubsequence = new int[k];
        int start = Math.max(0, k - n), end = Math.min(k, m);
        for (int i = start; i <= end; i++) {
            int[] subsequence1 = maxSubsequence(nums1, i);
            int[] subsequence2 = maxSubsequence(nums2, k - i);
            int[] curMaxSubsequence = merge(subsequence1, subsequence2);
            if (compare(curMaxSubsequence, 0, maxSubsequence, 0) > 0) {
                System.arraycopy(curMaxSubsequence, 0, maxSubsequence, 0, k);
            }
        }
        return maxSubsequence;
    }

    public int[] maxSubsequence(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();

        //和leetcode 402一样删除k个数字
        k = nums.length - k;

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && k > 0 && deque.peekLast() < nums[i]) {
                k--;
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }

        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        int[] result = new int[nums.length-k];

        int i = 0;

        while (!deque.isEmpty())
            result[i++] = deque.pollFirst();

        return result;
    }

    public int[] maxSubsequence1(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = length - k;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] res = new int[m+n];
        int i = 0, j = 0, k = 0;
        /**
         * 注意不是简单的比较bun[i] 和num[j]
         *
         * 反例：
         * 5 6 4  5 4 8 3
         *
         * 简单比较结果为： 5 6 4 4 8 3
         *
         * 正确结果：      5 6 5 4 8 4 3
         *
         */
        while(i < m && j < n){
            res[k++] = compare(nums1, i, nums2, j) >= 0 ? nums1[i++] : nums2[j++];
        }
        while(i < m){
            res[k++] = nums1[i++];
        }
        while(j < n){
            res[k++] = nums2[j++];
        }

        return res;
//        int x = subsequence1.length, y = subsequence2.length;
//        if (x == 0) {
//            return subsequence2;
//        }
//        if (y == 0) {
//            return subsequence1;
//        }
//        int mergeLength = x + y;
//        int[] merged = new int[mergeLength];
//        int index1 = 0, index2 = 0;
//        for (int i = 0; i < mergeLength; i++) {
//
//            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
//                merged[i] = subsequence1[index1++];
//            } else {
//                merged[i] = subsequence2[index2++];
//            }
//        }
//        return merged;
    }

    public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }

        //看谁还有长度
        return (x - index1) - (y - index2);
    }


    public static void main(String[] args) {

        /**
         * [3,4,6,5]
         * [9,1,2,5,8,3]
         * 5
         */
        int []num1 = new int[]{3,4,6,5};
        int []nums2 = new int[]{9,1,2,5,8,3};
        int k =5;
        CreateMaximumNumber createMaximumNumber = new CreateMaximumNumber();

        int[] ints = createMaximumNumber.maxNumber(num1, nums2, k);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }

    }
}
