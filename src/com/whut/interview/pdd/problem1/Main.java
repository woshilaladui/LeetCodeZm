package com.whut.interview.pdd.problem1;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/8 19:07
 * @desription
 */
public class Main {

    public static void main(String[] args) {

        int N;
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int r = scanner.nextInt();

            x = Math.abs(x);
            y = Math.abs(y);

            //不在坐标上
            if (x == 0 || y == 0) {
                if (Math.abs(x * x) + Math.abs(y * y) >= r * r) {
                    System.out.println(2);
                }else {
                    System.out.println(4);
                }
            }
            else {
                //不在坐标轴上
                if (Math.abs(x * x) + Math.abs(y * y) < r * r) {
                    System.out.println(4);
                } else if (Math.abs(x * x) + Math.abs(y * y) == r * r) {
                    System.out.println(3);
                } else {
                    int dx = Math.abs(x);
                    int dy = Math.abs(y);

                    if (dx == r && dy == r) {
                        System.out.println(2);
                    }else if(dx < r && dy < r){
                        System.out.println(4);
                    } else if (dx < r || dy < r) {
                        System.out.println(2);
                    } else if (dx == r || dy == r) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }

                }
            }

        }

    }


}
