package com.whut.algorithm.high.frequence.common.problem8_string_to_integer_atoi;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/12 17:13
 * @desription
 */
public class StringToIntegerAtoi {

    public static int myAtoi(String s) {

        //"words and 987"
        char[] c_s = s.trim().toCharArray();

        int n = c_s.length;

        int result = 0;

        //默认正数
        boolean flag = true;
        int occurrencesNum = 0;

        for (int i = 0; i < n; i++) {

            char c = c_s[i];


            if (c == '-') {
                if (occurrencesNum >= 1 || i > 0 && c_s[i - 1] == '0')
                    return 0;
                flag = false;
                occurrencesNum++;
            } else if (c == '+') {
                if (occurrencesNum >= 1||i > 0 && c_s[i - 1] == '0')
                    return 0;
                occurrencesNum++;
            } else if (!Character.isDigit(c)) {
                break;
            } else {
                int temp = Integer.parseInt(c_s[i] + "");
                //判断是否越界
                if (result > (Integer.MAX_VALUE  - temp)/10) {
                    return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                result = result * 10 + temp;
            }

        }

        return flag ? result : -result;
    }

    public static void main(String[] args) {

        String s = "-5-";
        System.out.println(myAtoi(s));
   //     System.out.println(Integer.MAX_VALUE);
    //    System.out.println(Math.pow(2,31)-1);



    }
}
