package com.whut.algorithm.high_frequence.problem349_intersection_of_two_arrays;

import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/9 19:33
 * @desription
 */
public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len1 = nums1.length;
        int len2 = nums2.length;

        int []intersection = new int[len1 + len2];

        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < len1 && index2 < len2){

            int num1 = nums1[index1];
            int num2 = nums2[index2];

            if(num1 == num2){
                if(index == 0 || intersection[index -1] != num1){
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            }else if(num1 < num2){
                index1++;
            }else {
                index2++;
            }

        }

        return Arrays.copyOfRange(intersection,0,index);
    }

    public static void main(String[] args) {
        int []nums1 = new int[]{1,2,2,1};
        int []mums2 = new int[]{2,2};

        int []c = intersection(nums1,mums2);

        for (int i : c) {
            System.out.print(i);
        }
    }
}
