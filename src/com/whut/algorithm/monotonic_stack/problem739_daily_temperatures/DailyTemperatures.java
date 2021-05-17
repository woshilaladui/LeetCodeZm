package com.whut.algorithm.monotonic_stack.problem739_daily_temperatures;

import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/14 11:57
 * @desription
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] T) {

        Stack<Integer> stack = new Stack<>();
        int n = T.length;
        int[] result = new int[n];

        //倒着入栈
        for (int i = n-1; i >= 0; i--) {
            //个字矮的出栈
            while (!stack.empty() && T[stack.peek()] <= T[i])
                stack.pop();

            result[i] = stack.empty() ? 0 : (stack.peek() - i);

            //注意存的是距离，是下标
            stack.push(i);
        }

        return result;

    }

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        int[] result = dailyTemperatures(T);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }

}
