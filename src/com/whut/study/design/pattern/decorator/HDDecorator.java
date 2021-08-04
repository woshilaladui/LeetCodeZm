package com.whut.study.design.pattern.decorator;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/4 11:22
 * @desription
 */
//红豆类 具体装饰者
public class HDDecorator extends CondimentDecorator{

    private Beverage beverage;

    public HDDecorator() {
    }

    public HDDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "加红豆";
    }

    @Override
    public double cost() {
        return beverage.cost() + 2.0;
    }
}
