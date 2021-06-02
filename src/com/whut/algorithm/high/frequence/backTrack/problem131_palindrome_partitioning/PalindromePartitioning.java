package com.whut.algorithm.high.frequence.backTrack.problem131_palindrome_partitioning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/19 16:21
 * @desription
 */
public class PalindromePartitioning {

    private static boolean isPalindrom(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }

        return left >= right;

    }

    public static List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        //backTrack(s, result, temp, 0);
        backTrack(s, result, temp, 0, s.length());

//        for (LinkedList<String> list : result) {
//            for (String s1 : list) {
//                System.out.print(s1 + " ");
//            }
//            System.out.println();
//        }

        return result;

    }


    /**
     * 参考problem40 不能拿重复的值，排序后增加index标志来表示从index开始往后遍历
     *
     * @param s
     * @param result
     * @param temp
     * @param index
     * @param len
     */
    private static void backTrack(
            String s,
            List<List<String>> result,
            List<String> temp,
            int index,
            int len
    ) {

        if (index == len) {
            result.add(new LinkedList<>(temp));
            return;
        }

        for (int i = index; i < len; i++) {

            //不是回文
            if (!isPalindrom(s.substring(index, i + 1)))
                continue;

            temp.add(s.substring(index, i + 1));
            backTrack(s, result, temp, i + 1, len);
            temp.remove(temp.size() - 1);
        }


    }

    private static void backTrack(
            String s,
            List<List<String>> result,
            List<String> temp,
            int index
    ) {


        //从index位置切割，前面已经判断过了
        String tempStr = s.substring(index);

        if (String.join("", temp).length() == s.length()) {
            //System.out.println("tempStr = " + tempStr);

            result.add(new LinkedList<>(temp));
        }

        for (int i = 0; i < tempStr.length(); i++) {
            String str = tempStr.substring(0, i + 1);

            if (isPalindrom(str)) {
                temp.add(str);
            } else {
                continue;
            }
            backTrack(s, result, temp, index + i + 1);
            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        partition("aab");
    }
}
