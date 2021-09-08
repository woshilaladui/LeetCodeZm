package com.whut.interview.huawei.problem1;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/1 20:27
 * @desription
 */
public class Main2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n =scanner.nextInt();
        String []strs = new String[n];
        String ln = scanner.nextLine();
        for (int i = 0; i < 3; i++) {
            strs[i] = scanner.nextLine();
        }

        for (String str : strs) {
            System.out.println(str);
        }
    }
}
