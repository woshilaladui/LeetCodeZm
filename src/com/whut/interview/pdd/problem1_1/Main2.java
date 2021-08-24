package com.whut.interview.pdd.problem1_1;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/22 19:43
 * @desription
 */
public class Main2 {

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0"))
            return "0";
        String result = "0";
        char[] arrayNum1 = num1.toCharArray();
        char[] arrayNum2 = num2.toCharArray();
        int len1 = arrayNum1.length;
        int len2 = arrayNum2.length;
        for (int i = len2 - 1; i >= 0; i--) {
            int y = arrayNum2[i] - '0';
            StringBuilder cur = new StringBuilder();
            int carry = 0;
            //需要补几个零
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
            result = add(result, cur.reverse().toString());
        }
        return result;
    }

    private static String add(String num1, String num2) {

        char[] arrayNum1 = num1.toCharArray();
        char[] arrayNum2 = num2.toCharArray();
        int i = arrayNum1.length - 1;
        int j = arrayNum2.length - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? arrayNum1[i] - '0' : 0;
            int y = j >= 0 ? arrayNum2[j] - '0' : 0;
            int result = x + y + carry;
            sb.append(result % 10);
            carry = result / 10;
            i--;
            j--;
        }
        if (carry != 0) {
            sb.append(carry % 10);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int T;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            for (int j = 1; j < Integer.MAX_VALUE; j++) {
                String temp = multiply(M + "", j + "");
                if(temp.length() == N){
                    System.out.println(temp);
                    break;
                }else if(temp.length() > N){
                    System.out.println(-1);
                    break;
                }
            }
        }
    }
}
