package com.whut.algorithm.refelect;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/10 19:54
 * @desription
 */
public class User {

    private int id;
    private String name;

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private void say(String name){
        System.out.println(name);
    }

    private static void sayHello(String hello){
        System.out.println(
                "hello"
        );
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
