package com.whut.algorithm.high.frequence.problem55_JumpGame;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/9 18:37
 * @desription
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {

        int []index = new int[nums.length];

        for(int i=0;i<nums.length;i++)
            index[i] = nums[i] + i;

        int jump = 0;//记录用当前位置
        int max_index = index[0];//记录0到jump位置能够跳跃的最大位置

        /**
         * jump要小于数组长度并且jump不能够大于能够跳跃的最大长度
         */
        while (jump < nums.length && jump<= max_index){

            //更新最大跳跃距离
            if(max_index < index[jump])
                max_index = index[jump];

            jump++;

        }

        if(jump == nums.length)
            return true;

        return false;
    }

    public static void main(String[] args) {

        /**
         * index数组记录当前位置能够到达的最远位置
         *
         * 贪心更新这个最大值
         */

        int[] nums = new int[]{2,3,1,1,4};

        System.out.println(canJump(nums));

    }

}
