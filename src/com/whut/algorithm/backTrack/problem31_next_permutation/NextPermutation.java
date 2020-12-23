package com.whut.algorithm.backTrack.problem31_next_permutation;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/18 10:42
 * @desription
 */
public class NextPermutation {

    private static void reverse(int[] nums, int i, int j) {

        int temp;
        while (i < j) {

            temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }

    }

    //交换从后往前扫描第一个不递增的那个数字和后面那个比他大的数字交换
    //在数据结构中可用户判断是否为合法的出栈序列
    public static void nextPermutation2(int[] nums) {
        //特殊情况
        if (nums == null || nums.length <= 1)
            return;


        //寻找第一个不递增的数字
        int i = nums.length - 2;
        // 从后往前找到第一个降序的,相当于找到了我们的回溯点
        while (i > -1 && nums[i + 1] <= nums[i]) i--;

        //排除321 ->123的情况
        if (i > -1) {
            //j是最后一个数字
            int j = nums.length - 1;
            // 找到从右边起第一个大于nums[i]的，并将其和nums[i]进行交换
            // 因为如果交换的数字比nums[i]还要小肯定不符合题意
            while (nums[j] <= nums[i]) {
                System.out.println("i = " + i);
                System.out.println("j = " + j);
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        /**
         * 132->交换1，2
         * 132->231  交换交换点i之后的序列，使之成为递增序列
         */
        reverse(nums, i + 1, nums.length - 1);





    }

    //这样会超时
    public static void nextPermutation(int[] nums) {
        int[] tempNums = nums.clone();
        List<List<Integer>> tempResult = permute(nums);

        for (List<Integer> list : tempResult) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        List<Integer> result;

        List<Integer> temp = new LinkedList<>();
        for (int i = 0; i < tempNums.length; i++) {
            temp.add(tempNums[i]);
        }
        //获取下标
        int index = tempResult.indexOf(temp);


        if (index == tempResult.size() - 1)
            result = tempResult.get(0);
        else
            result = tempResult.get(index + 1);


        //输出
        System.out.print("[");
        for (int i = 0; i < result.size() - 1; i++) {
            System.out.print(result.get(i) + ",");
        }

        System.out.println(result.get(result.size() - 1) + "]");

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        backTrack(result, path, nums);
        return result;

    }

    private static void backTrack(
            List<List<Integer>> result,
            List<Integer> path,
            int[] nums
    ) {

        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (path.contains((Integer) nums[i]))
                continue;

            path.add(nums[i]);
            backTrack(result, path, nums);
            path.remove(path.size() - 1);

        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2};
        nextPermutation2(nums);

        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }

}
