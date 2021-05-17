package com.whut.algorithm.backTrack.problem556_next_greater_element_iii;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/13 20:57
 * @desription
 */
public class NextGreaterElementIII {

    private static void reverse(int[] nums, int i, int j) {

        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }

    }

    private static String nextPermutation(int[] nums) {
        //特殊情况
        if (nums == null || nums.length <= 1)
            return "-1";

        //寻找第一个不递增的数字
        int i = nums.length - 2;
        // 从后往前找到第一个降序的,相当于找到了我们的回溯点
        while (i > -1 && nums[i + 1] <= nums[i]) i--;


        //321 -> -1
        if (i == -1)
            return "-1";

        //从右边往左边找第一个比它大的数字
        int j = nums.length - 1;
        // 找到从右边起第一个大于nums[i]的，并将其和nums[i]进行交换
        // 因为如果交换的数字比nums[i]还要小肯定不符合题意
        while (nums[j] <= nums[i]) {
            j--;
        }
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;

        //逆序 i+1 到末尾的数字
        reverse(nums, i + 1, nums.length - 1);

        int result = 0;

        for (i = 0; i < nums.length; i++) {
            result += nums[nums.length - i - 1] * Math.pow(10, i);
        }

        return result+"";
    }

    public static int nextGreaterElement(int n) {

        char[] c_n = String.valueOf(n).toCharArray();

        int length = c_n.length;
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = c_n[i] - 48;
        }

        int result = Integer.parseInt(nextPermutation(nums));

        return result;
    }

    public static void main(String[] args) {

        System.out.println(nextGreaterElement(246731));

    }
}
