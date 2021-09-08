package com.whut.interview.shenceshuju.problem3;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/7 10:20
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Deque<String> stack = new LinkedList<>();
        int len = 0;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                len++;
                List<Integer> tem = new ArrayList<>();
                tem.add(i);
                while (stack.peek().charAt(0) != '(') {
                    stack.poll();
                }
                String temp = stack.peek();
                tem.add(0, temp.charAt(temp.length() - 1) - '0');
                stack.poll();
//                tem.add(0,stack.poll().charAt(1)-'0');
                res.add(tem);
            } else {
                stack.push(str.charAt(i) + "" + i);
            }
        }
        Collections.sort(res, Comparator.comparingInt(a -> a.get(0)));
        System.out.println(len);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(res.get(i).get(j));
            }
        }
    }
}
