package com.whut.study.design.pattern.observer;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/4 10:30
 * @desription
 */

/**
 * 具体的被观察对象
 */
public class WeixinUser implements Observer {
    private String name;

    public WeixinUser() {
    }

    public WeixinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " - " + message);
    }
}
