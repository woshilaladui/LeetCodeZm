package com.whut.algorithm.commonProblem.problem224_basic_calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/2 19:43
 * @desription
 */
public class BasicCalculator {

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
    private static Queue<String> changeInfixToSuffix(char[] infix) {

        Stack<Character> stack = new Stack<>();

        Queue<String> queueSuffix = new LinkedList<>();

        int len = infix.length;

        int temp = 0;

        for (int i = 0; i < len; i++) {
            //数字直接存入后缀表达式中
            if (Character.isDigit(infix[i])) {
                //计算数字 如27 需要将 2*10 + 7
                //当下一个不是数字的时候说明结束了。需要入队列
                temp = 10 * (temp) + (infix[i] - '0');

                //单个数字0需要入队列，如果是9040这样数字需要判断后面还有没有数字
                if(i == len -1 || infix[i] == '0'&&!Character.isDigit(infix[i+1])){
                    queueSuffix.offer(temp+"");
                    //重置
                    temp = 0;
                }

                //n++;
                //suffix.append(infix[i]);
            } else {
                if(temp != 0)
                   queueSuffix.offer(temp+"");
                temp = 0;

                //可能是运算符，也可能是括号
                //栈空直接入栈
                if (stack.empty())
                    stack.push(infix[i]);
                    //是括号，则弹出栈中括号包括的所有运算符
                else if (infix[i] == ')') {
                    while (!stack.empty() && stack.peek() != '(')
                        //弹出括号的内容
                        //suffix.append(stack.pop());
                        queueSuffix.offer(stack.pop()+"");
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
                        //suffix.append(stack.pop());
                        queueSuffix.offer(stack.pop()+"");
                    }//end while
                    //将新进来的运算符入栈
                    stack.push(infix[i]);
                }//end else 运算符
            }//end else 符号
        }

        //全部出栈
        while (!stack.empty()) {
            //suffix.append(stack.pop());
            queueSuffix.offer(stack.pop()+"");
        }

//        String ss="";
//        while (!queueSuffix.isEmpty()){
//            ss+=queueSuffix.poll();
//        }
//
//        System.out.println("ss = "+ss);

        return queueSuffix;

    }

    private static int operation(int a, String op, int b) {
        if (op .equals("+"))
            return a + b;
        else if (op.equals("-"))
            return a - b;
        else if (op.equals("*"))
            return a * b;
        else if (op.equals("/")) {
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
        s = s.replace(" ", "");

        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {

        }

        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        Queue<String> queue = changeInfixToSuffix(s.toCharArray());
        int len = queue.size();
        for (int i = 0; i < len; i++) {

            String str = queue.poll();

            if(
                    str.equals("+")
                    ||
                            str.equals("-")
                    ||
                            str.equals("*")
            ){
                int b = stack.pop();
                int a = stack.pop();

                int c = operation(a, str, b);

                //将运算结果再入栈
                stack.push(c);
            }
            else {

                stack.push(Integer.parseInt(str));
            }//end else
        }//end for

        return stack.peek();
    }

    public static void main(String[] args) {
        String s = "(9568+(9040-(380+(2042-(7115)+(6294)-(4395-(5183+9744+(7746-(1099+2718))-(9370-(8561+(9302)-(7632+(8451-(1759+(7760))-(3377+5363+9093+(8332-(4492-(1151+(1165-8833+(775+(3749)+9399))+9112+(6273+(7285-(6112-(668-(7756-4316-(582+1835-(6644+690+1204-(7197+(7897))+(7009-(7262))-7782-(7858+(7644+(9461+(2224)-(7531-1095-(891+1022)+2197-(9855)))+(6663-(7417-(6158-(3610))+(1481))-(4182+(4761)))+(5017))+(9990)+(6218)))-(2904)+(5631)-(8888)+3401+(3569))+(1135))-(3695-(7713+(3479)-(9813+(8171+(8616-8026+(4634-(6973))-(9761-(623-4782)+(2514)+(6233)))))+(6140))-(6641)-8611+(8389)+8074-(4412))-(3703)+(9688+(9513))))-(4987)))+(9647)))))))))-(2299))-(4785))))))";

        //53+4-12+7-101-3+5+30-83810610-8-7-00+7++10-5+3-2-90+7229-2-5+4+2+29+1+5+5+8-9-2-9-1+0++59-079+-1064-6+++0+2-107+8783-2+106-10+2-7-2-38++13-8-+6+41+-6++6+1-104+8+50++36-+9-4-2+--+++1----96++0++++3+1--7+-+-+++-
        //53+4-12+7-10101-3+5+30-838101061010-8-7-00+7++1010-5+3-2-90+7229-2-5+4+2+29+1+5+5+8-9-2-9-1+0++59-079+-101064-6+++0+2-10107+8783-2+10106-1010+2-7-2-38++13-8-+6+41+-6++6+1-10104+8+50++36-+9-4-2+--+++1----96++0++++3+1--7+-+-+++-
        //System.out.println(changeInfixToSuffix(s.toCharArray()));
        System.out.println(calculate(s));

    }
}
