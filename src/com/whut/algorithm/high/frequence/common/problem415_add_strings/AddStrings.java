package com.whut.algorithm.high.frequence.common.problem415_add_strings;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/13 9:00
 * @desription
 */
public class AddStrings {

    public static String addStrings(String num1, String num2) {

        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();


    }

    public static void main(String[] args) {
        int a = 123;
        int b = 78908;
        System.out.println(a + b);
        System.out.println(addStrings("9", "99"));
    }
}
