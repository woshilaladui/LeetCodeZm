package com.whut.study.circular_dependence;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/19 20:18
 * @desription
 */
public class A {
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
