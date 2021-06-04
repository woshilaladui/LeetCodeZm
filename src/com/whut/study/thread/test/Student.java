package com.whut.study.thread.test;

import java.util.Objects;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/3 19:43
 * @desription
 */
public class Student{


    public Integer id;
    public String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
