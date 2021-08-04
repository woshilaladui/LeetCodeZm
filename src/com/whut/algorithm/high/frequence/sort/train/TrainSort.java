package com.whut.algorithm.high.frequence.sort.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/4 21:29
 * @desription
 */
public class TrainSort {

    private static void bubbleSort(int[] nums) {
        //flag = false表示没有发生过位置交换，说明有序
        boolean flag;

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            flag = false;
            for (int j = n - 1; j > i; j--) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
            if (!flag)
                return;
        }
    }

    private static void selectSort(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int k = i;

            //寻找比num[k]小的数字
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[k])
                    k = j;
            }

            //交换i ,k 位置
            //此时k为最小值
            int temp = nums[k];
            nums[k] = nums[i];
            nums[i] = temp;
        }

    }

    private static void insertSort(int[] nums) {
        int n = nums.length;

        int j;

        for (int i = 1; i < n; i++) {
            /**
             * i为无序序列第一个数字
             * i-1为有序序列的最后一个数字
             */
            if (nums[i] < nums[i - 1]) {
                int temp = nums[i];

                for (j = i - 1; j >= 0 && nums[j] > temp; j--) {
                    nums[j + 1] = nums[j];
                }

                nums[j + 1] = temp;
            }

        }
    }

    private static int partion(int[] nums, int low, int high) {

        int priovtKey = nums[low];

        while (low < high) {

            while (low < high && nums[high] >= priovtKey)
                high--;

            nums[low] = nums[high];

            while (low < high && nums[low] <= priovtKey)
                low++;

            nums[high] = nums[low];
        }

        return low;
    }

    private static void quicklySort(int[] nums, int low, int high) {

        if (low <= high) {
            int partionLoc = partion(nums, 0, nums.length - 1);

            partion(nums, low, partionLoc - 1);
            partion(nums, partionLoc + 1, high);
        }
    }

    private static void quicklySort(int[] nums) {
        quicklySort(nums, 0, nums.length - 1);

    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[nums.length];

        if (high + 1 - low >= 0) System.arraycopy(nums, low, temp, low, high + 1 - low);

        int i, j, k;

        for (i = low, j = mid + 1, k = low; i <= mid && j <= high; k++) {
            if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else
                nums[k] = temp[j++];
        }

        while (i <= mid)
            nums[k++] = temp[i++];

        while (j <= high)
            nums[k++] = temp[j++];

    }

    private static void mergeSort(int[] nums, int low, int high) {
        if (low == high)
            return;

        int mid = low + (high - low) / 2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);

        merge(nums, low, mid, high);
    }

    private static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void adjust(int[] nums, int low, int high) {
        int i = low;

        //临时存储
        int temp = nums[low];

        for (int j = i * 2 + 1; j <= high; j = j * 2 + 1) {

            //寻找子节点中更小的节点
            if (j < high && nums[j + 1] < nums[j])
                j++;

            //子节点满足小顶堆概念
            if (nums[j] > temp)
                break;
            else {
                nums[j] = temp;

                i = j;
            }

        }
        nums[i] = temp;
    }

    private static void buildHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--)
            adjust(nums, i, nums.length - 1);
    }

    private static Integer[] heapSort(int[] nums) {

        List<Integer> list = new ArrayList<>();

        buildHeap(nums);

        for (int i = nums.length - 1; i >= 0; i--) {
            //每次把第一个元素挪到最后取
           // list.add(nums[0]);
            System.out.print(nums[0] + " ");
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            adjust(nums,0,i-1);
        }

        return list.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        int[] A = new int[]{53, 17, 78, 4, 45, 65, 87, 32};
        //mergeSort(A);

        Integer []result = heapSort(A);

        System.out.println();

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
