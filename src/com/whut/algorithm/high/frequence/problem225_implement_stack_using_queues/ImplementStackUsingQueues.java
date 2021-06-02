package com.whut.algorithm.high.frequence.problem225_implement_stack_using_queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/13 9:17
 * @desription
 */
public class ImplementStackUsingQueues {

    private static class MyStack {

        Deque<Integer> inQueue;
        Deque<Integer> outQueue;

        /** Initialize your data structure here. */
        public MyStack() {
            inQueue = new LinkedList<>();
            outQueue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            inQueue.addLast(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while (!inQueue.isEmpty()) {
                outQueue.addFirst(inQueue.pollFirst());
            }

            return outQueue.pollFirst();
        }

        /** Get the top element. */
        public int top() {
            while (!inQueue.isEmpty())
                outQueue.addFirst(inQueue.pollFirst());
            return outQueue.getFirst();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return inQueue.isEmpty() && outQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
    }

}
