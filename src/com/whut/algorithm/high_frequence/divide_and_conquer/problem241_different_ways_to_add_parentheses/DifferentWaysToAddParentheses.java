package com.whut.algorithm.high_frequence.divide_and_conquer.problem241_different_ways_to_add_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/25 11:03
 * @desription
 */
public class DifferentWaysToAddParentheses {

    /**
     *
     *
     * 遍历 字符串
     * 遇到操作符，就将左右两边的字符串，分别当作 两个表达式
     * @param expression
     * @return
     */
    public static List<Integer> diffWaysToCompute(String expression) {

        List<Integer> result = new ArrayList<>();

        if (expression == null || expression.length() == 0)
            return result;

        int length = expression.length();
        char[] charArray = expression.toCharArray();

        for (int i = 0; i < length; i++) {
            /**
             * 思想：遇到运算符，将其切分为左右两个表达式，划分为小问题
             */
            char ch = charArray[i];

            if (ch == '-' || ch == '+' || ch == '*') {
                List<Integer> leftList = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(expression.substring(i + 1));

                //合并操作
                /**
                 * 2 * (3 - 4*5)
                 *
                 * left = 2
                 * right = 3 - 4*5 = {-5 ,-17}
                 *
                 * 2 * (3 - (4*5)) = -34
                 * 2 * ((3-4) * 5) = -10
                 */
                for (Integer leftNum : leftList) {
                    for (Integer rightNum : rightList) {
                        if(ch == '+')
                            result.add(leftNum + rightNum);
                        else if(ch == '-')
                            result.add(leftNum - rightNum);
                        else
                            result.add(leftNum * rightNum);
                    }
                }//end for
            }
        }

        //最后单个数字
        if(result.isEmpty()){
            result.add(Integer.parseInt(expression));
        }

        return result;
    }

    public static void main(String[] args) {
       List<Integer> result = diffWaysToCompute("2*3-4*5");

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}