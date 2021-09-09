package com.whut.interview.xingye.problem1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
        String str = "dlsk";
        char[] strArr = str.toCharArray();
        int max = 0;
        int flag = 0;

        for (int i = 0; i < strArr.length; i++) {
            int lastIndex = str.lastIndexOf(strArr[i]);
            if(lastIndex == i){
                flag++;
            }
            max = Math.max(max, lastIndex - i - 1);
        }
        if (flag == strArr.length)
            System.out.println(-1);
        else
            System.out.println(max);
    }
}
