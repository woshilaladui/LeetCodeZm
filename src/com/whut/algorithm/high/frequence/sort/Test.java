package com.whut.algorithm.high.frequence.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/9 14:18
 * @desription
 */
public class Test {


    private static void adjust(int[] nums, int low, int high) {

        int i = low;

        int temp = nums[low];

        for (int j = i * 2 + 1; j <= high; j = j * 2 + 1) {

            //寻找父结点最小的结点
            if (j < high && nums[j] > nums[j + 1])
                j++;

            if (temp < nums[j])
                break;

            else {
                //交换
                nums[i] = nums[j];
                //继续往下找
                i = j;
            }
            //归位
            nums[i] = temp;
        }

    }

    private static void buildHeap(int[] nums) {
        //最后一个非叶子节点
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjust(nums, i, nums.length - 1);
        }
    }

    private static void heapSort(int[] nums) {
        buildHeap(nums);

        //每次将根节点换下
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.print(nums[0] + " ");
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            adjust(nums, 0, i - 1);
        }

    }

    private static void bubbleSort(int[] nums) {

        boolean flag;
        int n = nums.length - 1;

        for (int i = 0; i < n - 1; i++) {
            flag = false;//标记没有发生交换

            for (int j = n - 1; j > i; j--) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }

            if (!flag)
                return;

        }
    }

    private static int parition(int[] nums, int low, int high) {

        int pivotKey = nums[low];

        while (low < high) {

            while (low < high && nums[high] >= pivotKey)
                high--;

            nums[low] = nums[high];

            while (low < high && nums[low] <= pivotKey)
                low++;

            nums[high] = nums[low];

        }

        nums[low] = pivotKey;

        return low;
    }

    private static void quicklySort(int[] nums, int low, int high) {
        if (low <= high) {
            int pivotLoc = parition(nums, low, high);
            quicklySort(nums, low, pivotLoc - 1);
            quicklySort(nums, pivotLoc + 1, high);
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
//        quicklySort(nums,0,nums.length-1);
//
//        for (int num : nums) {
//            System.out.print(num + " ");
//        }


        List<String> list = new ArrayList<>(Arrays.asList("list"));
        // class java.util.ArrayList
        System.out.println(list.getClass());

        Object[] listArray = list.toArray();
        // class [Ljava.lang.Object;
        System.out.println(listArray.getClass());
        listArray[0] = new Object();

        System.out.println();

        List<String> asList = Arrays.asList("asList");
        // class java.util.Arrays$ArrayList
        System.out.println(asList.getClass());

        Object[] asListArray = asList.toArray();
        // class [Ljava.lang.String;
        System.out.println(asListArray.getClass());
        // java.lang.ArrayStoreException
        asListArray[0] = new Object();

    }

}
