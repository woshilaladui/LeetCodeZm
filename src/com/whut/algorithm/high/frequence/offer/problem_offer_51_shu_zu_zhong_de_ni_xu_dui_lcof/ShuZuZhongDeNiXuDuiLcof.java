package com.whut.algorithm.high.frequence.offer.problem_offer_51_shu_zu_zhong_de_ni_xu_dui_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/21 14:19
 * @desription
 */
public class ShuZuZhongDeNiXuDuiLcof {

    /**
     * 7, 5, 6, 4  逆序对 用来形容数组的混乱程度
     *
     * [7,5],[7,6],[7,4]
     * [5,4]
     * [6,4]
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {

        if (nums.length < 2)
            return 0;

        int[] temp = new int[nums.length];

        //System.arraycopy(nums, 0, temp, 0, nums.length);

        return reversePairs(nums, 0, nums.length - 1, temp);

    }

    /**
     * [low,high] 闭区间
     *
     * @param nums
     * @param low
     * @param high
     * @param temp
     * @return
     */
    private int reversePairs(int[] nums, int low, int high, int[] temp) {

        if (low == high)
            return 0;

        int mid = low + (high - low) / 2;

        int leftPairs = reversePairs(nums, low, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, high, temp);

        int mergePairs = merge(nums, low, mid, high, temp);

        return leftPairs + rightPairs + mergePairs;
    }

    /**
     * [left mid]
     * [mid+1,right]
     *
     * @param nums
     * @param low
     * @param mid
     * @param high
     * @param temp
     * @return
     */
    private int merge(int[] nums, int low, int mid, int high, int[] temp) {
        //闭区间
        for (int i = low; i <= high; i++)
            temp[i] = nums[i];

        int count = 0;
        int i, j, k;

        for (i = low, j = mid + 1, k = low; i <= mid && j <= high; k++) {
            if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                count += (mid - i + 1);
            }
        }

        while (i <= mid) {
            nums[k++] = temp[i++];
        }

        while (j <= high) {
            nums[k++] = temp[j++];
        }

        return count;

    }

    public static void main(String[] args) {

        //[7,5,6,4]
        ShuZuZhongDeNiXuDuiLcof shuZuZhongDeNiXuDuiLcof = new ShuZuZhongDeNiXuDuiLcof();

        int[] nums = new int[]{7, 5, 6, 4};

        int result = shuZuZhongDeNiXuDuiLcof.reversePairs(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println(result);
    }
}
