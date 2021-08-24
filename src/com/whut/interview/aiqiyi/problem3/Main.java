package com.whut.interview.aiqiyi.problem3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/22 16:15
 * @desription
 */
public class Main {

    public static void main(String[] args) {
        Main myMain = new Main();
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String str = next.substring(2);
        System.out.println(myMain.solveQueues(Integer.valueOf(str)));
    }

    public List<List<String>> solveQueues(int n) {
        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                arr[i][j] = '.';
        }

        List<List<String>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[0][i] = 'Q';
            solve(list,1,n,arr);
            arr[0][i] = '.';
        }
        return list;
    }

    public void solve(List<List<String>> list, int row, int n, char[][] arr) {

        if (row == n) {
            list.add(charToList(arr));
            return;
        }

        //遍历每一行
        for (int i = 0; i < n; i++) {
            if (valid(row, i, arr, n)) {
                arr[row][i] = 'Q';
                solve(list,row+1,n,arr);
                arr[row][i] = '.';
            }
        }


    }

    public boolean valid(int row, int col, char[][] arr, int n) {
        //判断上面没有
        for (int i = 0; i < row; i++) {
            if (arr[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (arr[i][j] == 'Q')
                return false;
        }
        return true;
    }


    public List<String> charToList(char[][] arr) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j]);
            }
            list.add(sb.toString());
        }
        return list;
    }


}
