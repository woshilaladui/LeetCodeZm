package com.whut.algorithm.modifying_array_in_place.problem283_move_zeroes;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/14 18:42
 * @desription
 */
public class MoveZeroes {

    private static int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {

                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


    private static void moveZeroes(int[] nums) {

        int p = removeElement(nums,0);

        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);

        for (int num : nums) {
            System.out.print(num+" ");
        }

    }

}
