package com.whut.algorithm.high.frequence.problem12_integer_to_roman;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/26 15:08
 * @desription
 */
public class IntegerToRoman {

    public static String intToRoman(int num) {

        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] sympol = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        //贪心的思想
        for (int i = 0; i < values.length && num >= 0; i++) {
            while (values[i] <= num){
                num -= values[i];
                sb.append(sympol[i]);
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(intToRoman(11));
    }
}
