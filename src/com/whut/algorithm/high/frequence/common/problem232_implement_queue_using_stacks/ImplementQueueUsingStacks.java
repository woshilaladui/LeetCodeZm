package com.whut.algorithm.high.frequence.common.problem232_implement_queue_using_stacks;

import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/9 19:21
 * @desription
 */
public class ImplementQueueUsingStacks {
    class MyQueue {

        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            inStack.add(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(outStack.empty()){
                inStackToOutStack();
            }
            return outStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(outStack.empty()){
                inStackToOutStack();
            }
            return outStack.peek();
        }

        public void inStackToOutStack(){
            while (!inStack.empty()){
                outStack.add(inStack.pop());
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return outStack.empty() && inStack.empty();
        }
    }

    public static void main(String[] args) {


    }
}
