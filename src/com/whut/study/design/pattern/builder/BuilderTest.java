package com.whut.study.design.pattern.builder;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/4 10:47
 * @desription
 */
public class BuilderTest {
    public static void main(String[] args) {
        Person person = new Person.Builder()
                .setHeight(10.0)
                .setId(12)
                .setName("asd")
                .setWeight(14.0)
                .build();

        System.out.println(person);

        Person person2 = Person.builder()
                .setName("bb")
                .setId(122)
                .setHeight(12.0)
                .setWeight(123.0)
                .build();

        System.out.println(person2);
    }
}
