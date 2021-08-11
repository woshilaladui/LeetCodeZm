package com.whut.algorithm.high.frequence.common.problem402_remove_k_digits;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/11 15:11
 * @desription
 */
public class RemoveKDigits {

    /**
     * 123531这样「高位递增」的数，肯定不会想删高位，高位肯定想尽量小，会尽量删低位。
     * 432135这样「高位递减」的数，会想干掉高位，直接让高位变小，效果很好。
     *
     *
     * leetcode 321
     *
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();

        char[] numArray = num.toCharArray();

        for (int i = 0; i < numArray.length; i++) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > numArray[i]) {
                k--;
                stack.pollLast();
            }
            stack.offerLast(numArray[i]);
        }

        //处理k没有减完
        for (int i = 0; i < k; i++) {
            stack.pollLast();
        }

        StringBuilder sb = new StringBuilder();

        boolean leadingZero = true;

        while (!stack.isEmpty()) {
            char digit = stack.pollFirst();

            //排除10200  k = 1 -> 0200 -> 200
            if (leadingZero && '0' == digit)
                continue;

            leadingZero = false;

            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num = "10200";
        int k = 1;
        System.out.println(removeKdigits(num,k));
    }
}
