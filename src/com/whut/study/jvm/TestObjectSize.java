package com.whut.study.jvm;

import org.apache.lucene.util.RamUsageEstimator;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/11 12:29
 * @desription
 */
public class TestObjectSize {
    public static void main(String[] args) {

        int [][]a = new int[10][100];

        long aSize = RamUsageEstimator.shallowSizeOf(a);

        int [][]b = new int[10][999999];

        long bSize = RamUsageEstimator.shallowSizeOf(b);

        System.out.println(aSize);
        System.out.println(bSize);

        int []c = new int[10];
        int []d = new int[100];
        System.out.println(RamUsageEstimator.shallowSizeOf(c));
        System.out.println(RamUsageEstimator.shallowSizeOf(d));

    }
}
