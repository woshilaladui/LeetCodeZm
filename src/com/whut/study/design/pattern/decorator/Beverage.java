package com.whut.study.design.pattern.decorator;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/4 11:16
 * @desription
 */
//奶茶
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
