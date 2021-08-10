package com.whut.algorithm.interview.pdd.problem4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/25 20:11
 * @desription
 */
public class Problem4 {

    private int getMax() {

        Scanner in = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();

//        for(int i =0;i<10;i++)
//            map.put(i,in.nextInt());

        map.put(0,0);
        map.put(1,4);
        map.put(2,0);
        map.put(3,0);
        map.put(4,0);
        map.put(5,0);
        map.put(6,0);
        map.put(7,0);
        map.put(8,0);
        map.put(9,0);

        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            while (map.get(i) != 0) {
                sb.append(i);
                map.put(i, map.get(i) - 1);
            }
        }

        return doGetMax(sb.toString());
    }

    private int doGetMax(String str) {

        int max = Integer.MIN_VALUE;

        for (int i = 2; i < str.length() - 2; i++) {
            int a = Integer.parseInt(str.substring(0, i));
            int b = Integer.parseInt(str.substring(i));

            if (a * b > max)
                max = a * b;
        }

        return max;
    }

    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();

        System.out.println(problem4.getMax());
    }
}
