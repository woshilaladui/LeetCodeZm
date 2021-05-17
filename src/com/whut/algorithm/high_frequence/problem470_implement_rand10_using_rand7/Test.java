package com.whut.algorithm.high_frequence.problem470_implement_rand10_using_rand7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/9 10:30
 * @desription
 */
public class Test {

    public static int[] getLeastNumbers(int[] arr, int k) {

        int[] result = new int[k];

        heapSort(arr, result, k);

//        for (int i : result) {
//            System.out.print(i+" ");
//        }
        return result;
    }


    private static void buildHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjust(nums, i, nums.length - 1);
        }
    }

    private static void adjust(int[] nums, int low, int high) {
        int i = low;
        int temp = nums[low];

        for (int j = 2 * i + 1; j <= high; j = j * 2 + 1) {

            if (j < high && nums[j] > nums[j + 1])
                j++;

            if (temp < nums[j])
                break;
            else {

                nums[i] = nums[j];

                i = j;
            }
        }
        nums[i] = temp;
    }

    private static void heapSort(int[] nums, int[] result, int k) {

        buildHeap(nums);

        int j = 0;

        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            //System.out.print(nums[0] + " ");

            result[j++] = nums[0];

            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;

            adjust(nums, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        //4、5、1、6、2、7、3、8
        int[] nums = new int[]{4, 5, 1, 6, 2, 7, 3, 8};

        int k = 4;

        int[] result = new int[k];

        result = getLeastNumbers(nums, k);

//        for (int i : result) {
//            System.out.print(i + " ");
//        }
//        List<String> list = new ArrayList<>();
//      //  list.add("1");
//        list.add("2");
//
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            if ("2".equals(item)) {
//                iterator.remove();
//            }
//        }

        List<String> listS = new ArrayList<>();
        listS.add("2");
        Iterator<String> iterator1 = listS.iterator();
        while (iterator1.hasNext()){
            String s =  iterator1.next();
            if("2".equals(s)){
                iterator1.remove();
            }
        }


        List<String> list = new ArrayList<>();
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){

            String s =  iterator.next();
            if("2".equals(s)){
                iterator.remove();
            }

            String integer = iterator.next();
            if("2".equals(integer))
                list.remove(integer);
        }

//        for (String item : list) {
//            if ("2".equals(item)) {
//                list.remove(item);
//            } }


    }
}
