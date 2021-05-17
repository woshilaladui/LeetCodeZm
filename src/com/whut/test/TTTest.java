package com.whut.test;

import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/2 21:27
 * @desription
 */
public class TTTest {

    //运算符的优先级
    private static int getOperatorPriority(char c) {
        switch (c) {
            case ')':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
        }
        return -1;
    }

    //中缀转后缀
    private static String changeInfixToSuffix(char[] infix) {

        StringBuilder suffix = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        int len = infix.length;

        for (int i = 0; i < len; i++) {
            //数字直接存入后缀表达式中
            if (Character.isDigit(infix[i]))
                suffix.append(infix[i]);
            else {
                //可能是运算符，也可能是括号
                //栈空直接入栈
                if (stack.empty())
                    stack.push(infix[i]);
                    //是括号，则弹出栈中括号包括的所有运算符
                else if (infix[i] == ')') {
                    while (!stack.empty() && stack.peek() != '(')
                        //弹出括号的内容
                        suffix.append(stack.pop());
                    //将'('弹出
                    if (!stack.empty())
                        stack.pop();
                } else if (infix[i] == '(') {
                    //右括号直接入栈
                    stack.push('(');
                } else {
                    //运算符
                    /**
                     * 栈顶元素的优先级>=入栈元素优先级则要出栈
                     */
                    while (
                            !stack.empty()
                                    &&
                                    stack.peek() != '('
                                    &&
                                    getOperatorPriority(stack.peek()) >= getOperatorPriority(infix[i])
                    ) {
                        suffix.append(stack.pop());
                    }//end while
                    //将新进来的运算符入栈
                    stack.push(infix[i]);
                }//end else 运算符
            }//end else 符号
        }

        //全部出栈
        while (!stack.empty()) {
            suffix.append(stack.pop());
        }

        return suffix.toString();

    }

    private static int operation(int a, char op, int b) {
        if (op == '+')
            return a + b;
        else if (op == '-')
            return a - b;
        else if (op == '*')
            return a * b;
        else if (op == '/') {
            if (b == 0)
                return Integer.MIN_VALUE;
            return a / b;
        } else
            return Integer.MIN_VALUE;
    }

    /**
     * 从后缀中直接遍历
     * 若是数字则直接入栈
     * 若是操作符则弹出栈顶2个元素进行运算后再入栈
     * 最后返回栈顶即可
     *
     * @param s
     * @return
     */
    private static int calculate(String s) {

        //去掉空格
        s = s.replace(" ","");

        try {
            return Integer.parseInt(s);
        }catch (NumberFormatException e){

        }

        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        char[] suffix = changeInfixToSuffix(s.toCharArray()).toCharArray();
        int len = suffix.length;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(suffix[i]))
                stack.push(suffix[i] - '0');
            else {

                char op = suffix[i];
                int b = stack.pop();
                int a = stack.pop();

                int c = operation(a, op, b);

                //将运算结果再入栈
                stack.push(c);

            }//end else
        }//end for

        return stack.peek();
    }

    public static void main(String[] args) {
        String s = "5+3-4-(1+2-7+(10-1+3+5+(3-0+(8-(3+(8-(10-(6-10-8-7+(0+0+7)-10+5-3-2+(9+0+(7+(2-(2-(9)-2+5+4+2+(2+9+1+5+5-8-9-2-9+1+0)-(5-(9)-(0-(7+9)+(10+(6-4+6))+0-2+(10+7+(8+(7-(8-(3)+(2)+(10-6+10-(2)-7-(2)+(3+(8))+(1-3-8)+6-(4+1)+(6))+6-(1)-(10+(4)+(8)+(5+(0))+(3-(6))-(9)-(4)+(2))))))-1)))+(9+6)+(0))))+3-(1))+(7))))))))";

        System.out.println(changeInfixToSuffix(s.toCharArray()));

    }
}
