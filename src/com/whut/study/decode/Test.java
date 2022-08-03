package com.whut.study.decode;

import org.apdplat.word.vector.T;

import java.util.HashMap;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/10 11:11
 * @desription
 */
public class Test {
    static {
        new Test();
    }

    static {
        System.out.println("2");
    }

    {
        System.out.println("asdasd");
    }

    public Test() {
        System.out.println("test1");
    }

    public static void main(String[] args) {
        Test test = new Test();

    }
}


