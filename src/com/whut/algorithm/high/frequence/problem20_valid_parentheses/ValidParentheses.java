package com.whut.algorithm.high.frequence.problem20_valid_parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/12 19:38
 * @desription
 */
public class ValidParentheses {

    /**
     * 不适合 要求顺序
     * @param s
     * @return
     */
    public static boolean isValid1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        char[] cArray = s.toCharArray();

        for (char c : cArray) {

            switch (c) {
                case '(':
                case '[':
                case '{':
                    if (!map.containsKey(c)) {
                        map.put(c, 1);
                        continue;
                    }
                    map.put(c, map.get(c) + 1);
                    break;
                case ')':
                    map.put('(', map.getOrDefault('(',0) - 1);
                    break;
                case ']':
                    map.put('[', map.getOrDefault('[',0) - 1);
                    break;
                case '}':
                    map.put('{', map.getOrDefault('{',0) - 1);
                    break;

            }
        }//end for

        for (Map.Entry entry : map.entrySet()) {
            if (!entry.getValue().equals(0))
                return false;
        }

        return true;

    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        char[] c_s = s.toCharArray();

        int n = c_s.length;

        for (int i = 0; i < n; i++) {
            char c = c_s[i];

            if (stack.empty())
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
        //"([)]"
        System.out.println(isValid1("([)]"));
        ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<>();

    }
}
