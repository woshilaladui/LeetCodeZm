package com.whut.algorithm.high.frequence.common.problem67_add_binary;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/29 19:00
 * @desription
 */
public class AddBinary {

//    public static String addBinary(String a, String b) {
//
//
//        StringBuilder sb = new StringBuilder();
//
//        int n = Math.max(a.length(), b.length());
//
//        int carry = 0;
//
//        for (int i = 0; i < n; i++) {
//            carry += i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
//            carry += i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
//
//            System.out.println(carry % 2 + '0');
//
//            sb.append((char) (carry % 2 + '0'));
//
//            carry /= 2;
//
//        }
//        //处理高位进位
//        if(carry > 0)
//            sb.append(1);
//
//        return sb.reverse().toString();
//    }

    public String addBinary(String a, String b) {
        char[] arrayNum1 = a.toCharArray();
        char[] arrayNum2 = b.toCharArray();
        int i = arrayNum1.length - 1;
        int j = arrayNum2.length - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? arrayNum1[i] - '0' : 0;
            int y = j >= 0 ? arrayNum2[j] - '0' : 0;
            int result = x + y + carry;
            sb.append(result % 2);
            carry = result / 2;
            i--;
            j--;
        }

        if(carry != 0)
            sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {


    }
}
