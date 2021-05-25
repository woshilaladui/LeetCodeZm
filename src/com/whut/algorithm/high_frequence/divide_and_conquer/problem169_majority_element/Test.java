//package com.whut.algorithm.high_frequence.divide_and_conquer.problem169_majority_element;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Administrator
// * @version 1.0.0
// * @date 2021/5/25 10:45
// * @desription
// */
//public class Test {
//
//    public static List<Integer> diffWaysToCompute(String input) {
//        if (input == null || input.length() <= 0) {
//            return new ArrayList<Integer>();
//        }
//
//        ArrayList<Integer> curRes = new ArrayList<Integer>();
//        int length = input.length();
//        char[] charArray = input.toCharArray();
//
//
//        for (int i = 0; i < length; i++) {
//            char aChar = charArray[i];
//            if (aChar == '+' || aChar == '-' || aChar == '*') { // 当前字符为 操作符
//                List<Integer> leftList = diffWaysToCompute(input.substring(0, i));
//                List<Integer> rightList = diffWaysToCompute(input.substring(i + 1));
//                for (int leftNum : leftList) {
//
//                    for (int rightNum : rightList) {
//
//                        if (aChar == '+') {
//                            curRes.add(leftNum + rightNum);
//                        } else if (aChar == '-') {
//                            curRes.add(leftNum - rightNum);
//                        } else {
//                            curRes.add(leftNum * rightNum);
//                        }
//                    }
//                }
//
//            }
//        }
//
//        if (curRes.isEmpty()) {
//            curRes.add(Integer.valueOf(input));
//        }
//        return curRes;
//    }
//
//
//
//    public static void main(String[] args) {
//        List<Integer> result = diffWaysToCompute("2*3-4*5");
//        for (Integer integer : result) {
//            System.out.println(integer);
//        }
//    }
//}
