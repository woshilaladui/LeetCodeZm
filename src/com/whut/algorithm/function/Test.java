package com.whut.algorithm.function;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/18 15:15
 * @desription
 */
public class Test {

    public static void main(String[] args) {

        Integer a = 127;
        Integer b = 127;

        System.out.println(a == b);

        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);


//        List<Integer> list = new ArrayList<>();
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        Iterator<Integer> iterator = list.iterator();
//
//
//        while (iterator.hasNext()){
//
//            Integer number = iterator.next();
//            if (number % 2 == 0) {
//                // 抛出ConcurrentModificationException异常
//                System.out.println("number = " + number);
//                iterator.remove();
//            }
//        }
//
//        for (Integer integer : list) {
//            System.out.println(integer);
//        }

        //Function1<String,Integer> function1 = new Function1Imp();

//        Function1<String,Integer> function1 = (x,y)->{
//            return x.length();
//
//        };
//
//        System.out.println(function1.apply("asd",""));
//
//        System.out.println(function1.s());

    }
}
