package com.whut.daily2;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/9/14 16:57
 * @desription
 */
public class Problem4 {


    public static void main(String[] args) {


        int []nums1 = new int[]{1,2,3};
        int []nums2 = new int[]{5,8,10};



      //  System.out.println(findMedianSortedArraysBinarySearch(nums1,nums2));

        System.out.println("int max = " + Integer.MAX_VALUE);
        System.out.println("int min = " + Integer.MIN_VALUE);

        System.out.println();

    }

//    public static double findMedianSortedArraysBinarySearch1(int[] nums1, int[] nums2) {
//        // do binary search for shorter length array, make sure time complexity log(min(m,n)).
//        if (nums1.length > nums2.length) {
//            return findMedianSortedArraysBinarySearch(nums2, nums1);
//        }
//        int m = nums1.length;
//        int n = nums2.length;
//        int lo = 0;
//        int hi = m;
//        int maxLeftA = 0;
//        int minRightA = 0;
//        int maxLeftB = 0;
//        int minRightB = 0;
//
//        while (lo <= hi) {
//            // partition A position i
//            int i = lo + (hi - lo) / 2;
//            // partition B position j
//            int j = (m + n + 1) / 2 - i;
//
//            maxLeftA = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
//            minRightA = i == m ? Integer.MAX_VALUE : nums1[i];
//
//            maxLeftB = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
//            minRightB = j == n ? Integer.MAX_VALUE : nums2[j];
//
//            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
//                // total length is even
//                if ((m + n) % 2 == 0) {
//                    return (double) (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
//                } else {
//                    // total length is odd
//                    return (double) Math.max(maxLeftA, maxLeftB);
//                }
//            } else if (maxLeftA > minRightB) {
//                // binary search left half
//                hi = i - 1;
//            } else {
//                // binary search right half
//                lo = i + 1;
//            }
//            System.out.println("maxLeftA = "+ maxLeftA);
//            System.out.println("minRightA = " + minRightA);
//            System.out.println("maxLeftB = " +maxLeftB);
//            System.out.println("minRightB = "+ minRightB);
//        }
//
//
//
//        return 0.0;
//    }

    public static double findMedianSortedArraysBinarySearch(int[] nums1, int[] nums2) {
        // do binary search for shorter length array, make sure time complexity log(min(m,n)).

        /**
         * 始终抱持nums1长度最小
         */
        if (nums1.length > nums2.length) {
            return findMedianSortedArraysBinarySearch(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int lo = 0;
        int hi = m;

        /**
         *
         * i和j始终满足 i+ i = ( m+ n + 1)/2
         *
         */

        while (lo <= hi) {
            // partition A position i
            int i = lo + (hi - lo) / 2;
            // partition B position j
            int j = (m + n + 1) / 2 - i;

            int maxLeftA = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int minRightA = i == m ? Integer.MAX_VALUE : nums1[i];

            int maxLeftB = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int minRightB = j == n ? Integer.MAX_VALUE : nums2[j];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                // total length is even
                if ((m + n) % 2 == 0) {
                    /**
                     *
                     *
                     * A : 1 5
                     * B : 2 3 6 7
                     *
                     * 1 3 5 6
                     *
                     */
                    return (double) (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
                } else {
                    // total length is odd
                    /**
                     *
                     * eg A : 1 2 5
                     *    B : 3 4
                     *
                     *    -> 2 3 -> 3
                     *
                     */
                    return (double) Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                // binary search left half
                hi = i - 1;
            } else {
                // binary search right half
                lo = i + 1;
            }
        }
        return 0.0;
    }

}
