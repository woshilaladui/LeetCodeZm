package com.whut.algorithm.high_frequence.problem88_merge_sorted_array;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/16 19:57
 * @desription
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempNum = new int[n + m];
        System.arraycopy(nums1, 0, tempNum, 0, n + m);

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (tempNum[i] <= nums2[j]) {
                nums1[k++] = tempNum[i++];
            } else
                nums1[k++] = nums2[j++];
        }

        while (i < m)
            nums1[k++] = tempNum[i++];

        while (j < n)
            nums1[k++] = nums2[j++];

    }

    public static void main(String[] args) {
        int []nums1 = new int[]{1};
        int []nums2 = new int[]{};

        merge(nums1,1,nums2,0);

        for (int i : nums1) {
            System.out.print(i+" ");
        }
    }
}
