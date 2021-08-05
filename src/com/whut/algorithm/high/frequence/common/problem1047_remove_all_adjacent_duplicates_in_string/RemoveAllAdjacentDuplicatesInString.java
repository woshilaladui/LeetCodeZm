package com.whut.algorithm.high.frequence.common.problem1047_remove_all_adjacent_duplicates_in_string;

import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/11 9:49
 * @desription
 */
public class RemoveAllAdjacentDuplicatesInString {

    public static String removeDuplicates(String S) {
        //abbaca

        Stack<Character> stack = new Stack<>();

        StringBuilder result = new StringBuilder();

        char[] arrayS = S.toCharArray();

        for (int i = 0; i < arrayS.length; i++) {
            if(stack.empty()){
                stack.push(arrayS[i]);
                continue;
            }

            if(stack.peek() == arrayS[i]){
                stack.pop();
            }else {
                stack.push(arrayS[i]);
            }
        }

        stack.forEach(c->{
            result.append(c);
        });


        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(""));
    }
}
