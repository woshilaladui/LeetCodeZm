package com.whut.study.design.pattern.decorator;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/4 11:19
 * @desription
 */
//奶茶装饰者
public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;

    public abstract String getDescription();
}
