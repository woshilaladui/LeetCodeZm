package com.whut.algorithm.high.frequence.test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/3 9:50
 * @desription
 */
public class Test {

    public List<List<String>> partition(String s) {

        List<List<String>> result = new LinkedList<>();
        List<String> path = new LinkedList<>();

        backTrack(result, path, s, 0);

        for (List<String> list : result) {
            for (String s1 : list) {
                System.out.print(s1+" ");
            }
        }

        return result;
    }

    private void backTrack(List<List<String>> result, List<String> path, String s, int index) {
        if (index == s.length()) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if(!isPartition(s.substring(index,i+1)))
                continue;

            path.add(s.substring(index,i+1));
            backTrack(result,path,s,i+1);
            path.remove(path.size()-1);
        }

    }


    private static boolean isPartition(String s) {
        int left = 0, right = s.length() - 1;

        char[] arrayS = s.toCharArray();

        while (left < right) {
            if (arrayS[left] != arrayS[right])
                return false;
            left++;
            right--;
        }

        return true;
    }


    public static void main(String[] args) {
        Test test = new Test();

        test.partition("aab");
    }
}
