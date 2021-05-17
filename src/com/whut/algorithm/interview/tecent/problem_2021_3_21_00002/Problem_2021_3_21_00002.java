package com.whut.algorithm.interview.tecent.problem_2021_3_21_00002;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/24 19:16
 * @desription
 */
public class Problem_2021_3_21_00002 {

    private static Map<Integer, Integer> map = new HashMap<>();

    private static int solve2(int num) {

        //long[] dp = new long[num + 1];
        map.put(0, 0);
        map.put(1, 1);

        //dp[0] = 0;
        //dp[1] = 1;

        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 2 == 0)
                map.put(i, Math.min(map.get(i / 3), Math.min(map.get(i / 2), map.get(i - 1))) + 1);
            else if (i % 3 == 0) {
                map.put(i, Math.min(map.get(i / 3), map.get(i - 1)) + 1);
            } else if (i % 2 == 0) {
                map.put(i, Math.min(map.get(i / 2), map.get(i - 1)) + 1);
            } else {
                map.put(i, map.get(i - 1) + 1);
            }
        }


        return map.get(num);
    }

    private static int solve(int num) {

        int cur = 0;

        if (map.containsKey(num)) {
            cur = map.get(num);
        } else if (num % 3 == 0 && num % 2 == 0) {
            cur = Math.min(solve(num - 1), Math.min(solve(num / 3), solve(num / 2))) + 1;
        } else if (num % 3 == 0) {
            cur = Math.min(solve(num - 1), solve(num / 3)) + 1;
        } else if (num % 2 == 0) {
            cur = Math.min(solve(num - 1), num / 2) + 1;
        } else {
            cur = solve(num - 1) + 1;
        }


        map.put(num, cur);

        return cur;
    }

    public static void main(String[] args) {
        map.put(0, 0);

        System.out.println(solve2(200000));
    }

}
