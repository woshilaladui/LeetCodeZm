package com.whut.algorithm.high.frequence.common.problem491_increasing_subsequences;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/1 14:43
 * @desription
 */
public class Test {


    public static List<List<String>> partition(String s) {

        List<List<String>> result = new LinkedList<>();
        List<String> path = new LinkedList<>();

        backTrack(result, path, s, 0);

//        for (List<String> list : result) {
//            for (String s1 : list) {
//                System.out.print(s1+" ");
//            }
//        }

        return result;
    }

    private static boolean isPartition(char[] charArry) {
        int l = 0, r = charArry.length - 1;

        while (l < r) {
            if (charArry[l] == charArry[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
    }

    private static void backTrack(List<List<String>> result, List<String> path, String s, int index) {

        if (index == s.length()) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (!isPartition(s.substring(index, i + 1).toCharArray()))
                continue;

            path.add(s.substring(index, i + 1));
            backTrack(result, path, s, i + 1);
            path.remove(path.size() - 1);
        }

    }


    public static int reverse(int x) {

        if(x == 0)
            return 0;

        String tempS = x + "";

        StringBuilder sb = x > 0 ? new StringBuilder(tempS) : new StringBuilder(tempS.substring(1));



        return x > 0 ? Integer.parseInt(sb.reverse().toString()) : -1 * Integer.parseInt(sb.reverse().toString());
    }

    public static void main(String[] args) {


       // System.out.println(reverse(1534236469));
        //    partition("aab");


        int a = Integer.MAX_VALUE;
        int b = (int) (Math.pow(2,31)-1);
        System.out.println(a);
        System.out.println(b);
    }
}
