package com.whut.study.proxy.test;

import java.util.HashMap;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/1 21:40
 * @desription
 */
public class Test {
    public static void main(String[] args) {
        HashMap<Person,Integer> map = new HashMap<>();
        Person person1 = new Person(1,"a");
        map.put(person1,1);

        Integer person2 = map.get(new Person(1,"a"));

        System.out.println(person2);
    }
}
