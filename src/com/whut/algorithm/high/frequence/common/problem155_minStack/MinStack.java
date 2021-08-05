package com.whut.algorithm.high.frequence.common.problem155_minStack;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/29 15:10
 * @desription
 */
public class MinStack {

    /**
     * 辅助栈
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(
                val < minStack.peek() ? val : minStack.peek()
        );
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<Integer>();

        q.add(3);
        q.add(1);
        q.add(7);

        System.out.println(q.peek());
        System.out.println(q.poll());
    }
}
