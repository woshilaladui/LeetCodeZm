package com.whut.algorithm.high.frequence.offer.problem_offer_08_yong_liang_ge_zhan_shi_xian_dui_lie_lcof;



import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/23 10:02
 * @desription
 */
public class YongLiangGeZhanShiXianDuiLieLcof {


    /**
     *
     * 和leetcode 232一样 leetcode 225 用队列实现栈
     *
     * 双栈是是实现队列
     *
     * inStack  入队列时候使用
     * outStack 当出队列时候或者peek时候，outStack为空时将 inStack 入栈到outStack中
     */
    public static class CQueue{
        Deque<Integer> inStack;
        Deque<Integer> outStack;
        public CQueue() {
            inStack = new ArrayDeque<>();
            outStack = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            inStack.push(value);
        }

        //出队
        public int deleteHead() {

            if(isEmpty())
                return -1;

            if(outStack.isEmpty()){
                inStackToOutStack();
            }
            return outStack.removeFirst();
        }

        public int peek(){

            if(isEmpty())
                return -1;

            if(outStack.isEmpty()){
                inStackToOutStack();
            }
            return outStack.peek();
        }

        private void inStackToOutStack(){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }

        public boolean isEmpty(){
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }



    public static void main(String[] args) {
        /**
         * ["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
         * [[],[3],[],[],[]]
         */

        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        cQueue.deleteHead();
        cQueue.deleteHead();
    }
}
