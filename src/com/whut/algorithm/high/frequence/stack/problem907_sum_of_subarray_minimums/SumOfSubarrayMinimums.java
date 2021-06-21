package com.whut.algorithm.high.frequence.stack.problem907_sum_of_subarray_minimums;

import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/21 10:14
 * @desription
 */
public class SumOfSubarrayMinimums {

    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        //arr.push_back(0);               // 保证栈中所有元素都会被弹出计算
        int len = arr.length;
        long res = 0;
        for ( int i = 0; i < len; ++i ) {
            while ( !stk.empty() && arr[i] <= arr[stk.peek()] ) {
                int index = stk.peek(); stk.pop();
                int prev_index = -1;
                if ( !stk.empty() ) prev_index = stk.peek();
                int prev_count = index - prev_index - 1; // 数量m
                int next_count = i - index - 1;          // 数量n

                //res = res +

                //res += long((arr[index]) * (prev_count + 1) * (next_count + 1) % 10000);
                res %= 1000000;
            }
            stk.push(i);
        }
        return (int) res;

    }

    public static void main(String[] args) {

    }
}
