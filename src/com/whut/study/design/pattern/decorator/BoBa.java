package com.whut.study.design.pattern.decorator;

import java.util.TreeMap;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/4 11:18
 * @desription
 */
//波霸奶茶
public class BoBa extends Beverage {

    public BoBa() {
        description = "波霸";
    }

    @Override
    public double cost() {

        return 12.0;
    }

    @Override
    public String toString() {
        return "BoBa{" +
                "description='" + description + '\'' +
                '}';
    }

}
