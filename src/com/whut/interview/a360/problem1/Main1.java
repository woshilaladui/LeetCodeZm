package com.whut.interview.a360.problem1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/29 15:55
 * @desription
 */
public class Main1 {

    public static void main(String[] args) {
        int n, p, q;
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        p = scanner.nextInt();
        q = scanner.nextInt();

        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        Arrays.sort(scores);
        int maxCount = 0;
        int score = scores[scores.length - 1];
        int temp = 0;
        for (int i = scores.length - 1; i >= 0; i--) {
            if(scores[i] < score){
                temp++;
                score = scores[i];
            }

            if((100 - temp)*p + scores[i] * q >=6000){
                maxCount++;
            }
        }

        System.out.println(maxCount);

    }
}
