package com.whut.algorithm.high.frequence.offer.problem_offer_59_2_dui_lie_de_zui_da_zhi_lcof;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/6 20:41
 * @desription
 */
public class DuiLieDeZuiDaZhiLcof {

    class MaxQueue {

        LinkedList<Integer> monotonicQueue;
        LinkedList<Integer> tempQueue;

        public MaxQueue() {
            monotonicQueue = new LinkedList<>();
            tempQueue = new LinkedList<>();
        }

        public int max_value() {
            return monotonicQueue.isEmpty() ? -1 : monotonicQueue.getFirst();
        }

        public void push_back(int value) {
            while  (!monotonicQueue.isEmpty() && monotonicQueue.getLast() < value)
                monotonicQueue.pollLast();

            monotonicQueue.addLast(value);
            //单纯做出栈时候用
            tempQueue.addLast(value);
        }

        public int pop_front() {
            if(tempQueue.isEmpty())
                return -1;

            int result = tempQueue.poll();

            if(result == monotonicQueue.getFirst())
                monotonicQueue.pollFirst();

            return result;
        }
    }


    public static void main(String[] args) {

    }
}
