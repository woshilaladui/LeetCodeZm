package com.whut.test;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/12 15:02
 * @desription
 */
public class Person {

    @Override
    public int hashCode() {
        return name.hashCode();
    }

//    @Override
//    public boolean equals(Object obj) {
//        Person p = (Person) obj;
//
//       return this.name.equals(p.getName()) && this.id == p.getId();
//       // return false;
//    }

    private Integer id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
