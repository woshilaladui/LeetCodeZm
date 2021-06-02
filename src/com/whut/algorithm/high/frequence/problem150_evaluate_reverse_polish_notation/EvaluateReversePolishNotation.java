package com.whut.algorithm.high.frequence.problem150_evaluate_reverse_polish_notation;

import org.apache.tools.ant.util.StringUtils;

import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/29 16:30
 * @desription
 */
public class EvaluateReversePolishNotation {

    private static boolean isDigit(String token) {
        if (token.length() == 1) {
            return !token.equals("+") && !token.equals("-") && !token.equals("/") && !token.equals("*");
        }
        return true;
    }

    private static int caculate(String op, int a, int b) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0)
                    return a / b;
                else
                    return 0;
            default:
                return 0;
        }
    }

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (stack.empty() || isDigit(token))
                stack.push(Integer.parseInt(token));
            else {
                String c = token;
                //符号
                int b = stack.pop();
                int a = stack.pop();
                stack.push(caculate(c, a, b));
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        System.out.println(evalRPN(tokens));
        System.out.println(isDigit("-12"));
    }
}
