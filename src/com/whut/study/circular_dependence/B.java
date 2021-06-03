package com.whut.study.circular_dependence;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/19 20:18
 * @desription
 */
public class B {
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
