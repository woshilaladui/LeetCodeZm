package com.whut.algorithm.high.frequence.offer.problem_offer_53_zai_pai_xu_shu_zu_zhong_cha_zhao_shu_zi_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/2 21:24
 * @desription
 */
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {

    private int leftBinarySearch(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left >= nums.length || nums[left] != target)
            return -1;

        return left;
    }

    private int rightBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right < 0 || nums[right] != target)
            return -1;

        return right;
    }

    public int search(int[] nums, int target) {

        int leftIndex = leftBinarySearch(nums, target);
        System.out.println(leftIndex);
        int rightIndex = rightBinarySearch(nums, target);
        System.out.println(rightIndex);

        return rightIndex == -1 && leftIndex == -1 ? 0 : rightIndex - leftIndex + 1;

    }

    public static void main(String[] args) {
        ZaiPaiXuShuZuZhongChaZhaoShuZiLcof zaiPaiXuShuZuZhongChaZhaoShuZiLcof = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof();

        int[] nums = new int[]{5, 7, 7, 8, 8, 10};

        System.out.println(zaiPaiXuShuZuZhongChaZhaoShuZiLcof.search(nums, 6));
    }

}
