package com.whut.interview.meituan;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/20 16:15
 * @desription
 */
public class Main {

    private static int getNum(int[][] a, int m) {

        int day1 = 1;
        int day2 = 2;
        int day3 = 1;
        int day4 = 1;
        int day5 = 1;
        int day6 = 1;
        int day7 = 1;

        if (m == 1)
            return day1;

        if (m == 2)
            return day2;

        for (int i = 3; i <= m; i++) {
            if (i == 3) {
                    day3 = a[1][0];
            } else if (i == 4) {
                day4 = a[day3 - 1][day2 - 1];
            } else if (i == 5) {
                day5 = a[day4 - 1][day3 - 1];
            } else if (i == 6) {
                day6 = a[day5 - 1][day4 - 1];
            } else if (i == 7) {
                day7 = a[day6 - 1][day5 - 1];
            }
        }

        switch (m) {
            case 1:
                return day1;
            case 2:
                return day2;
            case 3:
                return day3;
            case 4:
                return day4;
            case 5:
                return day5;
            case 6:
                return day6;
            case 7:
                return day7;

        }

        return 0;
    }

    public static void main(String[] args) {
        /**
         * 3 7
         * 0 3 2
         * 3 0 3
         * 2 1 0
         */
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        BigInteger m = scanner.nextBigInteger();
        int tureM = 0;

        if(m.mod(BigInteger.valueOf(7)).toString().equals("0")){
            tureM = 7;
        }else {
            tureM = Integer.parseInt(m.mod(BigInteger.valueOf(7)).toString());
        }

        System.out.println(tureM);

        int[][] a = new int[n][n];

        //将其转化为1-7

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        if( n == 1){
            System.out.println(1);
        }else {
            System.out.println(getNum(a, tureM));
        }




    }
}
