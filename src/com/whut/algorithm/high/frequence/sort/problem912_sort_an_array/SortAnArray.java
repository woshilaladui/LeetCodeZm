package com.whut.algorithm.high.frequence.sort.problem912_sort_an_array;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/16 9:08
 * @desription
 */
public class SortAnArray {

    public int[] sortArray(int[] nums) {

        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low == high)
            return;

        int mid = low + (high - low) / 2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {

        int[] temp = new int[nums.length];

        if (high + 1 - low >= 0) System.arraycopy(nums, low, temp, low, high + 1 - low);

        int i, j, k;

        for (i = low, j = mid + 1, k = low; i <= mid && j <= high; k++) {
            if (temp[i] < temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }

        while (i <= mid) {
            nums[k++] = temp[i++];
        }

        while (j <= high) {
            nums[k++] = temp[j++];
        }

    }

    public static void main(String[] args) {
        SortAnArray sortAnArray = new SortAnArray();

        int []nums = new int[]{5,1,3,6,8,2};

        sortAnArray.sortArray(nums);

        for (int num : nums) {
            System.out.print(num);
        }

        System.out.println();

    }
}
