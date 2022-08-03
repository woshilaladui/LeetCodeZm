package com.whut.study.decode;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/10 11:12
 * @desription
 */
public class Parent {
    static {
        System.out.println("Parent static block");
    }

    {
        System.out.println("Parent non static block");
    }

    final static Value i = new Value("Parent static value");

    Value j = new Value("Parent non static value");

    Parent() {
        System.out.println("Parent Constructor");
    }
}
