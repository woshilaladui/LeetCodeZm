package com.whut.test;

import java.lang.ref.WeakReference;
import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/17 17:00
 * @desription
 */
public class Test {

    public static void main(String[] args) {



        String s1 = "abc";
        String s2 ="abc";
        String s3 = "ab";

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());


    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("执行回收");
    }
}
