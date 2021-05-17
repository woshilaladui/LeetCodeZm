package com.whut.algorithm.high_frequence.problem22_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/26 15:22
 * @desription
 */
public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        String path = "";

        backTrack(n,n,result,path);

        return result;
    }

    /**
     * @param left   左括号的还没有使用的数量
     * @param right  右括号的还没有用的数量
     * @param result 结果集
     * @param path   零时路径
     */
    public static void backTrack(int left, int right, List<String> result, String path) {

        //结束条件
        if (left < 0 || right < 0)
            return;

        //左括号数量必须大于等于右括号数量
        //注意left定义为还有left个左括号没有使用
        if (right < left)
            return;

        if(left == 0 && right == 0){
            result.add(path);
            return;
        }

        //回溯
        String temp = path;
        path += "(";
        backTrack(left - 1, right, result, path);
        //还原
        path = temp;

        path += ")";
        backTrack(left, right - 1, result, path);
        path = temp;

    }


    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
