package com.whut.algorithm.high.frequence.offer.problem_offer_51_shu_zu_zhong_de_ni_xu_dui_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/30 21:10
 * @desription
 */
public class TrainShuZuZhongDeNiXuDuiLcof {

    public int reversePairs(int[] nums) {

        if (nums.length < 2)
            return 0;

        int[] temp = new int[nums.length];

        return reversePairs(nums, 0, nums.length - 1,temp);
    }

    private int reversePairs(int[] nums, int low, int high,int[] temp) {

        if (low == high)
            return 0;

        int mid = (low + high) / 2;

        int leftPairs = reversePairs(nums, low, mid,temp);
        int rightPairs = reversePairs(nums, mid + 1, high,temp);

        int mergePairs = merge(nums, low, mid, high,temp);

        return leftPairs + rightPairs + mergePairs;

    }

    private int merge(int[] nums, int low, int mid, int high,int[] temp) {

        //将nums数组复制到辅助数组中
        for (int i = low; i <= high; i++)
            temp[i] = nums[i];

        int i, j, k;

        int count = 0;

        for (i = low, j = mid + 1, k = low; i <= mid && j <= high; k++) {

            if (temp[i] < temp[j]) {
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

    }
}
