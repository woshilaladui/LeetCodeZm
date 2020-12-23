package com.whut.daily4;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/9/17 10:59
 * @desription
 */
public class Problem7 {

    public static void main(String[] args) {

        System.out.println(reverse(2147483647));
        System.out.println(reverse(123123123));

//        int a = (int) (Math.pow(2, 31) );
//        int b = (int) (Math.pow(2, 31)-1);
//        int c = (int) (Math.pow(2, 30)-1);
//        int f = 2147483647;
//        int g = -2147483648;
//
//
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//
//        int pp = isoverflow("7463847412");
//
//        System.out.println(pp);
//
////        reverse(-120);
////        reverse(123);


    }
    public static int isoverflow(String tempStr){
        int a = -2147483648;
        int b = 2147483647;

        try {
            int result = Integer.parseInt(tempStr);
            return result;
        }catch (NumberFormatException e){
            return 0;
        }




    }

    public static int reverse(int x) {

        /**
         * 1 为正数
         *
         * 0 为负数
         */

        int flag = x < 0 ? 0 : 1;
        String result = "";

        String str = x + "", temp;

        if (flag == 0) {
            //负数
            temp = str;

            str = temp.substring(1, str.length());

        }

        if (str.charAt(str.length() - 1) != '0')
            result = result + str.charAt(str.length() - 1);

        for (int i = str.length() - 2; i >= 0; i--) {
            result = result + str.charAt(i);
        }

        //合并
        if (flag == 0)
            result = "-" + result;

        try {
            return Integer.parseInt(result);
        }catch (NumberFormatException e){
            return 0;
        }


    }

}
