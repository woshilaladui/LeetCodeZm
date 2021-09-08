package com.whut.interview.shenceshuju.problem3;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/7 10:28
 * @desription
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Deque<Character> stack1 = new ArrayDeque<Character>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        List<Integer[]> result = new ArrayList<>();
        int count = 0;
        char[] arrStr = str.toCharArray();

        for (int i = 0; i < arrStr.length; i++) {
            if (arrStr[i] == '(') {
                stack1.push(arrStr[i]);
                stack2.push(i);
            } else if (arrStr[i] == ')') {
                if (stack1.peek() == '(') {
                    count++;
                    result.add(new Integer[]{stack2.pop(),i});
                    stack1.pop();
                }
            }
        }
        System.out.println(count);
        Collections.sort(result, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i)[0]);
            System.out.println(result.get(i)[1]);
        }
    }
}
