package com.whut.algorithm.high.frequence.common.problem405_convert_a_number_to_hexadecimal;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/9 20:05
 * @desription
 */
public class ConvertANumberToHexadecimal {

    public static String toHex(int num) {
        final char []chars = new char[]{
                '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'
        };
        StringBuilder sb = new StringBuilder();
        do{
            sb.append(chars[num & 15]);
            num>>>=4;
        }while (num > 0);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        /**
         * 2147483647
         * -2147483648
         */
        System.out.println(toHex(-1));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
