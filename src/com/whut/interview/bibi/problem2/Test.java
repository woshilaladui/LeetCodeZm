package com.whut.interview.bibi.problem2;

import org.apdplat.word.vector.F;
import org.apdplat.word.vector.T;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/26 16:53
 * @desription
 */
public class Test {

    public  class Father{
        private String a = "father";

        public Father() {
            System.out.println("con father1");
            say();
            //

        }

        public void say(){
            System.out.println("i am father " + a );
        }

    }

    public  class Son extends Father{

        private String a = "child";

        public Son() {
            System.out.println("con son");
        }

        @Override
        public void say() {
            System.out.println("i am child " + a);
        }
    }

    public static void main(String[] args) {
        String[] split = "@2@3@".split("@");
        System.out.println(split.length);
        for (String s : split) {
            System.out.print(s);
        }
//        String s1 = "hello2";
//        String s2 = "hello";
//        String s3 = s2 + 2;
//
//        System.out.println(s1 == s3);
//
//
//        String s4 = "hello3";
//        final String s5 = "hello";
//        String s6 = s5 + 3;
//
//        System.out.println(s4 == s6);
//
//
//
//        Test test  = new Test();
//        Father father = test.new Father();
//        Son son = test.new Son();
////        son.say();
    }
}
