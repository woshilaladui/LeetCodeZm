package com.whut.interview.shenceshuju.problem1;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/7 10:01
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(getMinCount(scanner.nextInt()));
    }

    private static int getMinCount(int money) {
        int[] moneys = new int[]{100, 20, 10, 5, 1};
        int count = 0;
        int index = 0;

         while (money > 0) {
            while (index < moneys.length && money >= moneys[index] ){
                count++;
                money -= moneys[index];
            }
            index++;
        }
        return count;
    }
}
