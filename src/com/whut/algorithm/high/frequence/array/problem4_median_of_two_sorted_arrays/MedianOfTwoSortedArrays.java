package com.whut.algorithm.high.frequence.array.problem4_median_of_two_sorted_arrays;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/12 10:58
 * @desription
 */
public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int n = nums1.length;
        int m = nums2.length;

        if(n == 0){
            if(m % 2 == 0){
                return (double)(nums2[m/2] + nums2[m/2-1])/2;
            }else
                return (double)nums2[m/2];
        }

        // i + j = (n + m +1)/2
        /**
         *
         * 将nums1 nums2数组划分为两部分，
         *
         * 其中i,j为 第一个数组划分的左边一个元素的下标
         *        i
         * 2 4 6\15
         *      \
         * 1 7 8\ 10 17
         *         j
         *
         *  满足交叉小于
         *
         */

        int left = 0;
        int right = n;

        int maxLeftA ;
        int minRightA;
        int maxLeftB;
        int minRightB;

        while (left <= right) {

            int i = (left + right +1) / 2;
            int j = (n + m + 1) / 2 - i;

             maxLeftA = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
             minRightA = i == n ? Integer.MAX_VALUE : nums1[i];

             maxLeftB = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
             minRightB = j == m ? Integer.MAX_VALUE : nums2[j];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((n + m) % 2 == 0) {
                    return (double) (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
                }else {
                    return (double) (Math.max(maxLeftA,maxLeftB));
                }
            }else if(maxLeftA > minRightB){
                //去左边找
                right = i-1;
            }else {
                left = i;
            }

        }
        return 0;
    }

    public static void main(String[] args) {

        int []nums1 = new int[]{3};
        int []nums2 = new int[]{-2,-1};
        System.out.println(findMedianSortedArrays(nums1,nums2));

        Lock lock = new ReentrantLock(true);

        Condition condition = lock.newCondition();



    }
}
