package com.whut.algorithm.high.frequence.common.problem27_remove_element;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/26 16:22
 * @desription
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        /**
         * slow维护0- slow-1 没有val元素
         */
        int slow = 0,fast = 0;

        while (fast < nums.length){
            if(nums[fast] != val){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
