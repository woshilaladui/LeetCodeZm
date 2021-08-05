package com.whut.algorithm.high.frequence.common.problem350_intersection_of_two_arrays_ii;

import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/11 19:32
 * @desription
 */
public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] result = new int[Math.min(nums1.length, nums2.length)];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index = 0;

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]){
                result[index++] = nums1[i];
                i++;
                j++;
            }else if(nums1[i] < nums2[j])
                i++;
            else
                j++;

        }

        return Arrays.copyOfRange(result,0,index);

    }

    public static void main(String[] args) {
        int []nums1 = new int[]{4,9,5};
        int []nums2 = new int[]{9,4,9,8,4};
        int []result = intersect(nums1,nums2);
        for (int i : result) {
            System.out.print(i+" ,");
        }
    }
}
