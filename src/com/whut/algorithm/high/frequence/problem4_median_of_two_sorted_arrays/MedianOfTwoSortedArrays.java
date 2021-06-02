package com.whut.algorithm.high.frequence.problem4_median_of_two_sorted_arrays;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/1 14:30
 * @desription
 */
public class MedianOfTwoSortedArrays {

    /**
     * 二分思想
     * 交叉小于
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;

        int maxLeftA;
        int minRightA;
        int maxLeftB;
        int minRightB;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // maxLeftA, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            maxLeftA = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            minRightA = (i == m ? Integer.MAX_VALUE : nums1[i]);
            maxLeftB = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            minRightB = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                return (m + n) % 2 == 0 ? (double) (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2 : (double) (Math.max(maxLeftA, maxLeftB));
            } else if (maxLeftA <= minRightB) {
                left = i + 1;
            } else {
                right = i - 1;
            }
        }


        return 0;
        // return (m + n) % 2 == 0 ? (double) (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2 : (double) (Math.max(maxLeftA, maxLeftB));
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 4, 8};
        int[] nums2 = new int[]{1, 3, 5, 6, 7};
        System.out.println(findMedianSortedArrays(nums1, nums2));


    }
}
