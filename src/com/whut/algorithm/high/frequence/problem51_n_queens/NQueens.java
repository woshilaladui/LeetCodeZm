package com.whut.algorithm.high.frequence.problem51_n_queens;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/8 9:18
 * @desription
 */
public class NQueens {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new LinkedList<>();
        List<String> path = new LinkedList<>();

        backTrack(result,path,0,n);

//        for (List<String> list : result) {
//            for (String s : list) {
//                System.out.println(s);
//            }
//            System.out.println();
//        }

        return result;
    }

    private static void backTrack(
            List<List<String>> result,
            List<String> path,
            int row,
            int n
    ) {
        if (row == n) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(row, i, path, n)) {
                path.add(generateString(i, n));
                backTrack(result, path, row + 1, n);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isValid(int row, int column, List<String> path, int n) {

        //检查竖着的
        for (int i = 0; i < row; i++) {
            if (path.get(i).charAt(column) == 'Q')
                return false;
        }

        //主对角线
        for (int i = row - 1, j = column + 1; i >= 0 & j < n; i--, j++) {
            if (path.get(i).charAt(j) == 'Q')
                return false;
        }

        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (path.get(i).charAt(j) == 'Q')
                return false;
        }

        return true;
    }

    private static String generateString(int column, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < column; i++)
            sb.append(".");

        sb.append("Q");

        for (int i = column + 1; i < n; i++)
            sb.append(".");

        return sb.toString();
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }
}
