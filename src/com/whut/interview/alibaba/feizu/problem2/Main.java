package com.whut.interview.alibaba.feizu.problem2;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/20 19:51
 * @desription
 */
public class Main {
    public static void main(String[] args) {

        int n, m;
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        int[] quanNum = new int[n + 1];

        Quan []quans = new Quan[n+1];

        for (int i = 1; i <= n; i++) {
            quanNum[i] = i;
            quans[i].id = i;
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if(quanNum[a] <= quanNum[b]){
                //将a 合并到b
               // quanNum[]
            }
        }
    }

    public static class Quan {
        public int id;
        public int numId;
    }
}
