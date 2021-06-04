package com.whut.study.thread.test;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/3 19:43
 * @desription
 */
public class Main {

    public static int f(Student student){

        int a = 10;
        try {
            System.out.println(a / 0);
            student.id = 20;
            a = 20;
        } catch (ArithmeticException e) {
            System.out.println("error1");

            a = 30;
            student.id = 30;
            System.out.println("error2");
            return a;
        } finally {
            System.out.println("a = " + a);
            a = 40;
            student.id = 40;
            System.out.println("a = " + a);
            // 结果直接返回40
         //   return a;
        }
        return 0;
    }

    public static void main(String[] args) {
        Student student = new Student(1,"aa");
        System.out.println(f(student));
        System.out.println(student.toString());

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        copyOnWriteArrayList.add(1);

        System.out.println(copyOnWriteArrayList.size());
    }
}
