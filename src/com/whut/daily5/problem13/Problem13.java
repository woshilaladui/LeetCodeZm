package com.whut.daily5.problem13;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/9/18 16:29
 * @desription
 */
public class Problem13 {

    public static void main(String[] args) {

//        System.out.println(romanToInt("III"));
//        System.out.println(romanToInt("IV"));
//        System.out.println(romanToInt("IX"));
//        System.out.println(romanToInt("LVIII"));

        //"MCDLXXVI"''

        System.out.println(romanToInt("MCDLXXVI"));

    }


    public static int romanToInt(String s) {

        Map<String, Integer> map = new HashMap<>();


        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);


        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == 'I') {
                //监测是不是为IV IX
                char nextC =' ';
                if(i != s.length() -1)
                    nextC = s.charAt(i + 1);

                if (nextC == 'V') {
                    result += 4;
                    i++;
                } else if (nextC == 'X') {
                    result += 9;
                    i++;
                }else {
                    result += 1;
                }

            } else if (c == 'X') {
                char nextC = ' ';
                if(i != s.length() -1)
                    nextC= s.charAt(i + 1);

                if (nextC == 'L'){
                    result += 40;
                    i++;
                }

                else if (nextC == 'C'){
                    result += 90;
                    i++;
                }else {
                    result += 10;
                }


            } else if (c == 'C') {

                char nextC = ' ';

                if(i != s.length()-1)
                    nextC = s.charAt(i + 1);

                if (nextC == 'D'){
                    result += 400;
                    i++;
                }


                else if (nextC == 'M'){
                    result += 900;
                    i++;
                }else {
                    result += 100;
                }


            } else {

                result += map.get(c+"");

            }

        }//end for

        return result;

    }
}
