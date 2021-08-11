package com.whut.algorithm.high.frequence.common.problem316_remove_duplicate_letters;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/11 17:19
 * @desription
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 402
 * leetcode 321
 * leetcode 316
 * leetcode 1081
 * 单调栈
 */
public class RemoveDuplicateLetters {

    /**
     *
     * 单调栈
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {

        int len = s.length();

        //标记字母是否在栈中出现
        boolean[] vis = new boolean[26];

        int[] lastIndex = new int[26];

        char[] arrayS = s.toCharArray();

        for (int i = 0; i < len; i++) {
            lastIndex[arrayS[i] - 'a'] = i;
        }

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            //在栈中出现过
            if (vis[arrayS[i] - 'a'])
                continue;

            /**
             *  a b c    a   a要入栈时看b在后面出现过没，出现过就删掉
             */
            while (!deque.isEmpty() && deque.peekLast() > arrayS[i] && lastIndex[deque.peekLast() - 'a'] > i) {
                Character top = deque.pollLast();
                vis[top - 'a'] = false;
            }

            deque.offerLast(arrayS[i]);
            vis[arrayS[i] - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        for(char c:deque){
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
