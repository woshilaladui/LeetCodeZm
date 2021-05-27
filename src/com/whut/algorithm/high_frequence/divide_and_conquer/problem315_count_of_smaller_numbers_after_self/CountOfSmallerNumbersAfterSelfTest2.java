package com.whut.algorithm.high_frequence.divide_and_conquer.problem315_count_of_smaller_numbers_after_self;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/27 14:57
 * @desription
 */
public class CountOfSmallerNumbersAfterSelfTest2 {

    private int[] temp;
    private int[] index;
    private int[] tempResult;
    private int[] tempIndex;


    public List<Integer> countSmaller(int[] nums) {

        List<Integer> result = new ArrayList<>();

        temp = new int[nums.length];

        index = new int[nums.length];

        tempResult = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        tempIndex = new int[nums.length];

        countSmaller(nums, 0, nums.length - 1);

        for(int num:tempResult)
            result.add(num);

        return result;
    }

    public void countSmaller(
            int[] nums,
            int low,
            int high
    ) {
        if (low == high)
            return;

        int mid = low + (high - low) / 2;

        countSmaller(nums, low, mid);
        countSmaller(nums, mid + 1, high);


        merge(nums, low, mid, high);

    }

    private void merge(
            int[] nums,
            int low,
            int mid,
            int high
    ) {
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
            tempIndex[i] = index[i];
        }

        int i, j, k;

        for (i = low, j = mid + 1, k = low; i <= mid && j <= high; k++) {
            if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                index[k] = tempIndex[i];
                i++;
            } else {
                nums[k] = temp[j];
                index[k] = tempIndex[j];
                j++;
                for (int p = i; p <= mid; p++) {
                    tempResult[
                            tempIndex[p]
                            ]++;
                }
            }
        }//end for

        while (i <= mid) {
            nums[k] = temp[i];
            index[k] = tempIndex[i];
            k++;
            i++;
        }

        while (j <= high) {
            nums[k] = temp[j];
            index[k] = tempIndex[j];
            k++;
            j++;
        }

    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelfTest2 countOfSmallerNumbersAfterSelfTest2 = new CountOfSmallerNumbersAfterSelfTest2();

        List<Integer> result = countOfSmallerNumbersAfterSelfTest2.countSmaller(new int[]{0, 2, 1});

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}
