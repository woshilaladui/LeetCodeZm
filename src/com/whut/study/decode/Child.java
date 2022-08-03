package com.whut.study.decode;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/10 11:13
 * @desription
 */
public class Child extends Parent {
    static {
        System.out.println("Child static block");
    }

    final static Value i = new Value("Child static value");

    {
        System.out.println("Child non static block");
    }

    Value j = new Value("Child non static value");

    Child() {
        System.out.println("Child Constructor");
    }

    public static void main(String[] args) {
        Child child = new Child();
    }
}