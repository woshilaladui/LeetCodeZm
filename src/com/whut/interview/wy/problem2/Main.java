package com.whut.interview.wy.problem2;



import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/21 15:47
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Main m = new Main();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(m.findKthBit(n, k));
    }

    public char findKthBit(int n, int k) {
        // write code here
        String pre = "a";
        if (n == 1) {
            return 'a';
        } else {
            for (int i = 2; i <= n; i++) {
                String str = pre + String.valueOf((char) ('a' + i - 1)) + reverseAndInvert(pre);
                pre = str;
            }
        }

        return pre.charAt(k - 1);
    }

    public String reverseAndInvert(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        int n = str.length();

        char[] arrStr = str.toCharArray();

        for (int i = 0; i < n; i++) {
            char c1 = arrStr[i];
            char c2 = (char) (122 - (c1 - 'a'));
            stringBuilder.append(c2);
        }

        return stringBuilder.reverse().toString();
    }
}
