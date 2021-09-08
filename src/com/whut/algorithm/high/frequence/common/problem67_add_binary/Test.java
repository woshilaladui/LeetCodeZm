package com.whut.algorithm.high.frequence.common.problem67_add_binary;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/6 10:51
 * @desription
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(1,"a");

        System.out.println(person.hashCode());
        Person person1 = (Person) person.clone();
        System.out.println(person1.hashCode());
    }
}
