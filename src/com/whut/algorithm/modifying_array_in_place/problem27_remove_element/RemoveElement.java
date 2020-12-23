package com.whut.algorithm.modifying_array_in_place.problem27_remove_element;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/14 18:29
 * @desription
 */
public class RemoveElement {


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

    public static void main(String[] args) {

        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums,val));

    }

}
