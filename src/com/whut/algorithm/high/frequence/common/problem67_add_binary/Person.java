package com.whut.algorithm.high.frequence.common.problem67_add_binary;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/6 10:51
 * @desription
 */
public class Person implements Cloneable{
    int id;
    String username;

    public Person() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Person(int id, String username) {
        System.out.println("aaa");
        this.id = id;
        this.username = username;
    }
}
