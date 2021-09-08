package com.whut.algorithm.high.frequence.common.problem71_simplify_path;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/2 20:16
 * @desription
 */
public class Test {
    private static int i ;
    public static void main(String[] args) {
        System.out.println(test1());
        System.out.println(i);
    }

    private static int test1(){

        try {
            i = 2;
            return i;
//            return printX();
        }finally {
            i = 12;
            System.out.println("asdasd");
        }
    }

    private static int printX(){
        System.out.println("X");
        return -1;
    }
}
