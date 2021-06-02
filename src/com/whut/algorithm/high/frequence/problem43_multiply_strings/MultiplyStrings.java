package com.whut.algorithm.high.frequence.problem43_multiply_strings;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/15 11:01
 * @desription
 */
public class MultiplyStrings {

    public static String addString(String num1, String num2) {
        char[] arrayNum1 = num1.toCharArray();
        char[] arrayNum2 = num2.toCharArray();

        int i = arrayNum1.length - 1;
        int j = arrayNum2.length - 1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? arrayNum1[i] - '0' : 0;
            int y = j >= 0 ? arrayNum2[j] - '0' : 0;

            int result = x + y + carry;

            sb.append(result % 10);
            carry = result / 10;
            i--;
            j--;
        }

        return sb.reverse().toString();
    }

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0"))
            return "0";

        String result = "0";

        char[] arrayNum1 = num1.toCharArray();
        char[] arrayNum2 = num2.toCharArray();

        int len1 = num1.length();
        int len2 = num2.length();

        /**
         *
         * 见图片
         *
         */
        for (int i = len2 - 1; i >= 0; i--) {

            StringBuilder cur = new StringBuilder();
            int y = arrayNum2[i] - '0';

            int carry = 0;

            //看是第几位，补0
            for (int j = len2 - 1; j > i; j--)
                cur.append("0");

            for (int j = len1 - 1; j >= 0; j--) {
                int x = arrayNum1[j] - '0';
                int temp = x * y + carry;
                cur.append(temp % 10);
                carry = temp / 10;
            }

            if (carry != 0)
                cur.append(carry % 10);

            result = addString(result,cur.reverse().toString());

        }

        return result;

    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }

}
