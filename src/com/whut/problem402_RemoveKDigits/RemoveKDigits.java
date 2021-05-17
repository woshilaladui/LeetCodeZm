package com.whut.problem402_RemoveKDigits;

import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/9 15:55
 * @desription
 */
public class RemoveKDigits {

    public static String removeKdigits(String num, int k) {


        Stack<Integer> stack = new Stack<>();

        int length = num.length();

        stack.push(Integer.parseInt(String.valueOf(num.charAt(0))));
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < length; i++) {

            while (
                    !stack.empty() &&
                            stack.peek() > Integer.parseInt(String.valueOf(num.charAt(i))) &&
                            k > 0
            ) {

                //栈顶元素比要插入的元素大的时候弹出栈
                stack.pop();
                k--;
            }
            if (Integer.parseInt(String.valueOf(num.charAt(i))) != 0 || !stack.empty()) {
                stack.push(Integer.parseInt(String.valueOf(num.charAt(i))));
            }

        }//end fot
        //栈不空且，仍然可以删除数字
        //出现这样12345这样的情况，顺序弹栈
        while (!stack.empty() && k > 0) {
            stack.pop();
            k--;
        }


        for (int i = 0; i < stack.size(); i++) {
            //System.out.println("num = " + stack.get(i));
            result.append(stack.get(i));
        }


        //全0的情况
        if (result.toString().equals(""))
            result.append("0");

        return result.toString();

    }

    public static void main(String[] args) {


        System.out.println(removeKdigits("10200", 1));

    }
}
