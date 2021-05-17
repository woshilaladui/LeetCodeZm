package com.whut.algorithm.high_frequence.problem55_jump_game;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/19 19:51
 * @desription
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        //最大能够到达的位置
        int reach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > reach) {
                return false;
            }
            reach = Math.max(i + nums[i], reach);
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
