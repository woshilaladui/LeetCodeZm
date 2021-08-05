package com.whut.algorithm.high.frequence.common.problem224_basic_calculator;

import java.util.ArrayDeque;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/17 10:27
 * @desription
 */
public class BasicCalculator {
    public int calculate(String s) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(1);

        char[] arrayS = s.toCharArray();

        int n = s.length();
        int i = 0;
        //符号位
        int sign = 1;

        int result = 0;

        while (i < n) {
            if(arrayS[i] == ' '){
                i++;
            }
            else if(arrayS[i] == '+'){
                sign = stack.peek();
                i++;
            }else if(arrayS[i] == '-'){
                sign = -stack.peek();
                i++;
            }else if(arrayS[i] == '('){
                stack.push(sign);
                i++;
            }else if(arrayS[i] == ')'){
                stack.pop();
                i++;
            }else {
                long num = 0;
                while (i < n && arrayS[i] >= '0' && arrayS[i] <= '9') {
                    num = num * 10 + arrayS[i] - '0';
                    i++;
                }
                result += sign * num;
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
