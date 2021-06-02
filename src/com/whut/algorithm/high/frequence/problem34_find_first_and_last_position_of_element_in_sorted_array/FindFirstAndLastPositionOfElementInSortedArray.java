package com.whut.algorithm.high.frequence.problem34_find_first_and_last_position_of_element_in_sorted_array;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/29 15:30
 * @desription
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};

        return new int[]{leftBinarySearch(nums, target), rightBinarySearch(nums, target)};

    }

    private static int leftBinarySearch(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }

        if (left >= nums.length || nums[left] != target)
            return -1;

        return left;
    }

    private static int rightBinarySearch(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        if (right < 0 || nums[right] != target)
            return -1;

        return right;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 9;

        System.out.println("left = " + leftBinarySearch(nums, target));
        System.out.println("right = " + rightBinarySearch(nums, target));

        int[] result = searchRange(nums, target);

        System.out.println(result[0] + " " + result[1]);

    }
}
