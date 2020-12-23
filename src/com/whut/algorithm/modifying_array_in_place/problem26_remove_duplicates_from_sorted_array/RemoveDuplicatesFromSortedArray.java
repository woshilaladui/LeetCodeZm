package com.whut.algorithm.modifying_array_in_place.problem26_remove_duplicates_from_sorted_array;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/14 16:01
 * @desription
 */
public class RemoveDuplicatesFromSortedArray {


    /**
     * 快慢指针
     *
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums) {

        int slow = 0, fast = 0;

        int n = nums.length;

        if (n == 0)
            return 0;
        while (fast < n) {

            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }

    public static void main(String[] args) {


        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println(removeDuplicates(nums));

    }

}
