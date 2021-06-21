package com.whut.algorithm.high.frequence.problem394_decode_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/19 12:31
 * @desription
 */
public class DecodeString {

    public static String getString(Stack<String> stack) {

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    /**
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     *
     * @param s
     * @return
     */
    public static String decodeString(String s) {

        int len = s.length();
        int i = 0;
        char[] arrayS = s.toCharArray();

        /**
         * 数字存放在数字栈，字符串存放在字符串栈，遇到右括号时候弹出一个数字栈，字母栈弹到左括号为止。
         */
        Stack<Integer> integerStack = new Stack<>();
        Stack<String> characterStack = new Stack<>();
        Stack<String> workerStack = new Stack<>();
        int num = 0;

        while (i < len) {
            char c = arrayS[i];

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                //integerStack.push(c - '0');
            } else if (c == ']') {
                //出栈操作
                int n = integerStack.pop();

                String workStr;

                while (!(workStr = characterStack.pop()).equals("[")) {
                    workerStack.push(workStr);
                }

                StringBuilder copyStr2 = new StringBuilder();

                String str = getString(workerStack);

                for (int j = 0; j < n; j++)
                    copyStr2.append(str);

                characterStack.push(copyStr2.toString());

            } else {
                //[
                if(num != 0){
                    integerStack.push(num);
                    num = 0;
                }

                characterStack.push(c + "");
            }
            i++;
        }

        while (!characterStack.empty()) {
            workerStack.push(characterStack.pop());

        }

        return getString(workerStack);
    }

    public static void main(String[] args) {
        //"3[a]2[bc]"
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        System.out.println(decodeString("100[leetcode]"));
    }
}
