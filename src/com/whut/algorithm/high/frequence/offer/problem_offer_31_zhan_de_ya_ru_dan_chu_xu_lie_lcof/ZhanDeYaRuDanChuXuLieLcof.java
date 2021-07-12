package com.whut.algorithm.high.frequence.offer.problem_offer_31_zhan_de_ya_ru_dan_chu_xu_lie_lcof;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/9 16:10
 * @desription
 */
public class ZhanDeYaRuDanChuXuLieLcof {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {

    }
}
