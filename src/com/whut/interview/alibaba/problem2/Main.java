package com.whut.interview.alibaba.problem2;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/8 9:57
 * @desription
 */
public class Main {
    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        int segment = n / 2;
        int sn = ((1 + (segment + 1) * m) * (segment + 1) * m) / 2;
        System.out.println(sn);
    }

    private int getMinSegement(int n, int m) {
        //行切
        int segment = n / 2;
        int upSn = ((1 + (segment + 1) * m) * (segment + 1) * m) / 2;
        int downSn = ((1 + (n * m)) * n * m) / 2 - upSn;
        //列切
        return 0;
    }
}
