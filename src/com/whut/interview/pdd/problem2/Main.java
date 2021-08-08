package com.whut.interview.pdd.problem2;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/8 19:35
 * @desription
 */
public class Main {

    public static void main(String[] args) {
        int n, t, c;

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        t = scanner.nextInt();
        c = scanner.nextInt();

        int[] tg = new int[n];

        for (int i = 0; i < n; i++)
            tg[i] = scanner.nextInt();

        int left = 0;
        int right = 0;

        int count = 0;

        if(c > n){
            System.out.println(0);
        }else if(n == 1){
            if(tg[0] <=t)
                System.out.println(1);
            else
                System.out.println(0);
        }else {
            while (right < n -1) {
                //移入窗口
                right++;

                if (right - left + 1 == c) {
                    int i;
                    for (i = left; i <= right; i++) {
//                    System.out.println("left = "+left);
//                    System.out.println("right = "+right);
                        if (tg[i] > t)
                            break;
                    }

                    if (i == right + 1)
                        count++;

                    //移除窗口
                    left++;
                }
            }
            System.out.println(count);
        }



    }
}
