package com.whut.algorithm.high.frequence.monotonic_stack.problem496_next_greater_element_ii;

import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/13 20:02
 * @desription
 */
public class NextGreaterElementII {

    //只看比自己高的人，思想如图
    public static int[] nextGreaterElement(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        int n = nums.length;

        int[] ans = new int[n];
        //倒着进入栈
        for (int i = 2 * n - 1; i >= 0; i--) {
            //将比自己个子矮的人移除
            while (!stack.empty() && stack.peek() <= nums[i%n])
                stack.pop();

            //这个元素身后第一个高个子
            ans[i%n] = stack.empty() ? -1 : stack.peek();

            //将该人入栈
            stack.push(nums[i%n]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2, 4, 3};

        int[] result = nextGreaterElement(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }
}
