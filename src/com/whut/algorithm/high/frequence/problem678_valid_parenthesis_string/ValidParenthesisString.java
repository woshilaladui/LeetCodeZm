package com.whut.algorithm.high.frequence.problem678_valid_parenthesis_string;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/7 11:23
 * @desription
 */
public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        int left = 0, right = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            left += (s.charAt(i) == ')') ? -1 : 1;
            right += (s.charAt(n - i - 1) == '(') ? -1 : 1;
            if (left < 0 || right < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidParenthesisString validParenthesisString = new ValidParenthesisString();

        System.out.println(validParenthesisString.checkValidString("(())"));
    }
}
