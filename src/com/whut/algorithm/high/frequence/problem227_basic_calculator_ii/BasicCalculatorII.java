package com.whut.algorithm.high.frequence.problem227_basic_calculator_ii;

import com.whut.study.thread.test.A;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/17 10:48
 * @desription
 */
public class BasicCalculatorII {

    public static int calculate(String s) {

        int res = 0;

        s = s.replaceAll(" ","");

        char[] arrayS = s.toCharArray();

        //preSign代表
        char preSign = '+';

        int num = 0;

        /**
         * 遇到 + 将num入栈
         * 遇到 - 将-num入栈
         * 遇到* / 将栈顶元素与num运算入栈
         */
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            char c = arrayS[i];

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }

            //若是最后一个数字的话需要单独处理
            if (!Character.isDigit(c) || i == s.length() - 1) {

                if (preSign == '+') {
                    stack.push(num);
                } else if (preSign == '-') {
                    stack.push(-num);
                } else if (preSign == '*') {
                    stack.push(stack.pop() * num);
                } else if (preSign == '/') {
                    stack.push(stack.pop() / num);
                }

                preSign = c;
                //重置
                num = 0;
            }

        }

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

       // System.out.println("res = "+res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate(" 3/2 "));
    }
}
