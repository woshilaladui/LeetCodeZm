package com.whut.interview.fenghuo.problem3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/4 20:22
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[] vis = new boolean[n + 1];
        Arrays.fill(vis, true);
        int flag = 0;
        int index = 1;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (true) {
            for (int i = 1; i <= n; i++) {
                if (stack1.isEmpty()) {
                    stack1.push(i);
                }
            }
        }


    }
}
