package com.whut.algorithm.list;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/18 15:14
 * @desription
 */
public class User implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private int id;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
