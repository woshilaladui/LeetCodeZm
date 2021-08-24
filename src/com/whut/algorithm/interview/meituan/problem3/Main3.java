package com.whut.algorithm.interview.meituan.problem3;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/15 17:11
 * @desription
 */
public class Main3 {
    public static void main(String[] args) {
        Set<Integer> rSet = new TreeSet<>();
        Set<Integer> lSet = new TreeSet<>(Collections.reverseOrder());

        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, Integer> map = new HashMap<>();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int point = scanner.nextInt();
            String str = scanner.next();

            map.put(point, -1);

            if (str.equals("R")) {
                rSet.add(point);
            } else {
                lSet.add(point);
            }
        }

        int step = 0;

        while (!lSet.isEmpty() && !rSet.isEmpty() && lSet.iterator().next() <= rSet.iterator().next()) {

        }

    }
}
