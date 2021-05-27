package com.whut.algorithm.high_frequence.divide_and_conquer.problem315_count_of_smaller_numbers_after_self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/27 11:54
 * @desription
 */
public class CountOfSmallerNumbersAfterSelf {


    public List<Integer> countSmaller(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            if (!frequency.containsKey(num)) {
                frequency.put(num, 1);
            } else {
                frequency.put(num, frequency.get(num) + 1);
            }
        }

        for (int num : nums)
            map.put(num, 0);

        //中间数组
        int[] temp1 = new int[nums.length];
        //保存原数组
        int[] temp2 = new int[nums.length];


        System.arraycopy(nums, 0, temp2, 0, nums.length);

        //分治解决
        countSmaller(nums, 0, nums.length - 1, map, temp1);

        //处理结果
        List<Integer> result = new ArrayList<>();
        for (int num : temp2) {
            result.add(map.get(num) - frequency.get(num) + 1);
        }
//        for (Map.Entry entry : map.entrySet()) {
//            System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
//        }

        return result;
    }


    public void countSmaller(
            int[] nums,
            int low,
            int high,
            Map<Integer, Integer> map,
            int[] temp
    ) {

        if (low == high)
            return;

        int mid = low + (high - low) / 2;

        countSmaller(nums, low, mid, map, temp);
        countSmaller(nums, mid + 1, high, map, temp);

        merge(nums, low, mid, high, map, temp);

    }

    private void merge(
            int[] nums,
            int low,
            int mid,
            int high,
            Map<Integer, Integer> map,
            int[] temp
    ) {
        //闭区间
        for (int i = low; i <= high; i++)
            temp[i] = nums[i];

        int i, j, k;

        for (i = low, j = mid + 1, k = low; i <= mid && j <= high; k++) {
            if (temp[i] <= temp[j]) {

                nums[k] = temp[i++];
            } else {
                //处理比较结果
                nums[k] = temp[j++];
                for (int p = i; p <= mid; p++) {
                    map.put(temp[p], map.get(temp[p]) + 1);
                }
            }//end else
        }//end for

        while (i <= mid)
            nums[k++] = temp[i++];

        while (j <= mid)
            nums[k++] = temp[j++];


    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf countOfSmallerNumbersAfterSelf = new CountOfSmallerNumbersAfterSelf();

        List<Integer> result = countOfSmallerNumbersAfterSelf.countSmaller(new int[]{2, -1, -1, -2});
        for (Integer integer : result) {
            System.out.print(integer);
        }
    }
}
