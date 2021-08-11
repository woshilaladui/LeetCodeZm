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

        Integer [][]a = new Integer[10][100];

        long aSize = RamUsageEstimator.shallowSizeOf(a);

        Integer [][]b = new Integer[100][999999];

        long bSize = RamUsageEstimator.shallowSizeOf(b);

        System.out.println(aSize);
        System.out.println(bSize);


    }
}
