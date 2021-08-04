package com.whut.study.design.pattern.decorator;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/4 11:24
 * @desription
 */
public class DecoratorTest {
    public static void main(String[] args) {
//        Beverage boba = new BoBa();
//
//        boba = new HDDecorator(boba);
//
//        System.out.println(boba.getDescription() + "  " + boba.cost());

        TreeMap<Integer,Integer> map = new TreeMap<>();

        map.put(10,12);
        map.put(2,14);
        map.put(11,15);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println(map.firstEntry().getValue());



    }
}
