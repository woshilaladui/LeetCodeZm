package com.whut.algorithm.high.frequence.problem24_swap_nodes_in_pairs;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/18 9:50
 * @desription
 */
public class Test {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }

    public static void main(String[] args) {
        Test test = new Test();

        test = null;

        System.gc();
    }
}
