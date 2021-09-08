package com.whut.interview.a360.problem1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/29 16:19
 * @desription
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();

        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        Arrays.sort(scores);

        int result = 0;
        int score = scores[scores.length - 1];

        int index = 0;

        for (int i = scores.length - 1; i >= 0; i--) {
            if(scores[i] < score){
                index++;
                score = scores[i];
            }

            if((100 - index)*p+scores[i] *q >= 6000)
                result++;
        }

        System.out.println(result);
    }
}
