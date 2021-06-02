package com.whut.algorithm.high.frequence.problem_allSmallSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/10 10:24
 * @desription
 */
public class AllSmallSum {

    private static int merge(int[] nums, int low, int mid, int high) {

        int[] temp = new int[nums.length];


        int i, j, k, result = 0;

        System.arraycopy(nums, low, temp, low, high - low + 1);

        for (i = low, j = mid + 1, k = low; i <= mid && j <= high; k++) {
            if (temp[i] <= temp[j]) {
                result += (high - j + 1) * temp[i];
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }

        while (i <= mid)
            nums[k++] = temp[i++];

        while (j <= high)
            nums[k++] = temp[j++];

        return result;

    }

    private static int mergeSort(int[] nums, int low, int high) {

        if (low == high)
            return 0;

        int mid = low + (high - low) / 2;

        return mergeSort(nums, low, mid) + mergeSort(nums, mid + 1, high) + merge(nums, low, mid, high);

    }

    /**
     * 数组小和的定义如下：
     * 例如，数组s = [1, 3, 5, 2, 4, 6]，在s[0]的左边小于或等于s[0]的数的和为0；在s[1]的左边小于或等于s[1]的数的和为1；在s[2]的左边小于或等于s[2]的数的和为1+3=4；在s[3]的左边小于或等于s[3]的数的和为1；
     * 在s[4]的左边小于或等于s[4]的数的和为1+3+2=6；在s[5]的左边小于或等于s[5]的数的和为1+3+5+2+4=15。所以s的小和为0+1+4+1+6+15=27
     * 给定一个数组s，实现函数返回s的小和
     * [要求]
     * 时间复杂度为O(nlogn)，空间复杂度为O(n)
     * <p>
     * eg:
     * <p>
     * 例子：
     * <p>
     * [1,3,4,2,5]
     * <p>
     * 1左边比1小的数，没有；
     * <p>
     * 3左边比3小的数，1；
     * <p>
     * 4左边比4小的数，1、3；
     * <p>
     * 2左边比2小的数，1；
     * <p>
     * 5左边比5小的数，1、3、4、2；
     * <p>
     * 所以小和为1+1+3+1+1+3+4+2=16
     * <p>
     * 要求时间复杂度O(NlogN)，空间复杂度O(N)
     * <p>
     * 思想：归并排序
     * <p>
     * https://mp.weixin.qq.com/s/0ih4W6nawzFUPSj3GOnYTQ
     *
     * @param args
     */
    public static void main(String[] args) {
//        int []nums = new int[]{1,3,5,2,4,6};
//
//        for (int num : nums) {
//            System.out.print(num+" ");
//
//        }
//
//        System.out.println(mergeSort(nums,0,nums.length-1));



        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        for (Integer i : lists) {
            System.out.println(i);
        }
    }
}
