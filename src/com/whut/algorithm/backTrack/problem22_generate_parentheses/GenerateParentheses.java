package com.whut.algorithm.backTrack.problem22_generate_parentheses;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/30 17:19
 * @desription
 */
public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {

        List<String> result = new LinkedList<>();

        String path = "";

        backTrack(n,n,result,path);

        return result;
    }

    private static void backTrack(int left, int right, List<String> result,String path){

        //如果括号数量小于0不合法
        if(left<0||right<0)
            return;

        //左括号一定>=右括号，在回溯过程中
        if (right<left)
            return;

        if(left == 0 && right == 0){
            result.add(path);
            return;
        }

        //回溯
        //回溯左括号
        String temp = path;
        path+="(";
        backTrack(left-1,right,result,path);
        path = temp;

        //回溯右括号
        temp = path;
        path+=")";
        backTrack(left,right-1,result,path);
        path = temp;



    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }

}
