package com.whut.daily3;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/9/15 15:26
 * @desription
 */
public class Problem6 {

    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     *
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     *
     *
     * 其实就是一道推算的数学公式
     *
     * @param args
     */

    public static void main(String[] args) {
                     //
        //String s = "LEETCODEISHIRING";
        //String s = "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.";

        String s = "A";

        //System.out.println(0%2 == 0);



        System.out.println(convert3(s, 1));

    }


    public static String convert3(String s,int numRows){

        int index;

        /**
         * step_a + step_b = numRows - 1;
         */
        int step_a,step_b;

        //true表示向下跳变，false表示向上跳变
        boolean flag = true;

        StringBuilder result = new StringBuilder();

        if(s.length() == 1 || s.length() == 0 || numRows == 1)
            return s;

        for(int j=0;j<numRows;j++){

            //index重新定位
            index = j;

            //第一行和最后一行
            if(j == 0 || j == numRows -1){

                while (index <= s.length()-1){
                    //System.out.print(s.charAt(index));
                    result.append(s.charAt(index));

                    //重新定位index
                    index += (numRows -1)*2;
                }

            }else {//中间两行

                flag = true;

                while (index <= s.length()-1){
                    step_a = numRows -j - 1;
                    step_b = (numRows -1) - step_a;
                    //System.out.print(s.charAt(index));
                    result.append(s.charAt(index));

                    if(flag){
                        index += step_a*2;
                        flag = false;
                    }else {
                        index += step_b*2;
                        flag = true;
                    }

                }
            }//end else

        }//end for

        return result.toString();

    }

}
