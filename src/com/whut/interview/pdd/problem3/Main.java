package com.whut.interview.pdd.problem3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/8 20:16
 * @desription
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();

        String str = scanner.next();

        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == 'R') {
                index++;
            } else if (c == 'L') {
                index--;
            }

            if (index < 0)
                index = 0;
            if (index > sb.length())
                index = sb.length();

            if (c == 'D') {
                if (index != 0) {
                    sb.deleteCharAt(index - 1);
                    index--;
                }
            } else if (c == '(' || c == ')') {
                sb.insert(index, c);
                index++;
            }

            int res = score(sb);
            System.out.print(res + " ");
        }
    }

    private static int score(StringBuilder sb) {
        if (sb.length() == 0) {
            return 0;
        }

        Deque<Character> stack = new LinkedList<>();

        int index = 0;
        int depth1 = 0;
        int depth2 = 0;
        int maxDepth = 0;

        char flag = '(';

        while (index < sb.length()) {
            char c = sb.charAt(index);

            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.poll();
                else
                    stack.push(c);

                if (flag == c) {
                    depth2++;
                    maxDepth = Math.max(depth1, depth2);
                    depth1 = 0;
                }
            } else {
                stack.push(c);
                if (flag == c) {
                    depth1++;
                    maxDepth = Math.max(depth1, depth2);
                    depth2 = 0;
                }
            }
            index++;
        }

        if (stack.size() == 0)
            return maxDepth;

        return -1 * stack.size();

    }
}
