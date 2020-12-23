package com.whut.daily4;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/9/17 14:48
 * @desription
 */
public class Problem8 {

    public static void main(String[] args) {

        System.out.println(myAtoi("4193 with words"));

        //""

        System.out.println( myAtoi("words and 987"));


    }

    /**
     * 思想：
     * @param str
     * @return
     */
    public static int myAtoi(String str) {

        int flag = 1;
        //标注是否出现过数字
        boolean apperDight = false;
        boolean apperChar = false;
        String result = "";

        for(int i=0;i<str.length();i++){

            char c = str.charAt(i);

            if(c == ' ')
                continue;
           else if(Character.isDigit(c)){
                result = result + c;
                apperDight = true;
            }else {

               if(c == '-')
                   flag = 0;
               else {

               }
               //其他字符

                if(flag == 0)
                    return 0;

                apperChar = true;

                //已经出现过数字
                if(apperDight)
                    break;
                else
                    continue;

            }

        }//end for

        if (flag == 0)
            result = "-" + result;

        try {
            return Integer.parseInt(result);
        }catch (NumberFormatException e){
            return 0;
        }

    }
}
