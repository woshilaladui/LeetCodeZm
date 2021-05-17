package com.whut.algorithm.common.problem20_valid_parentheses;

import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/12 19:38
 * @desription
 */
public class ValidParentheses {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        char[] c_s = s.toCharArray();

        int n = c_s.length;

        for (int i = 0; i < n; i++) {
            char c = c_s[i];

            if(stack.empty())
                stack.push(c);
            else {
                switch (c) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(c);
                        break;
                    case ')':
                        if (stack.peek() == '(')
                            stack.pop();
                        else
                            return false;
                        break;
                    case '}':
                        if (stack.peek() == '{')
                            stack.pop();
                        else
                            return false;
                        break;
                    case ']':
                        if (stack.peek() == '[')
                            stack.pop();
                        else
                            return false;
                        break;
                }
            }





        }

        return stack.empty();
    }

    public static void main(String[] args) {
        //"{[]}"
        System.out.println(isValid("]"));
    }
}
