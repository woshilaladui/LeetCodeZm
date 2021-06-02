package com.whut.study.proxy.static_.business;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/11 16:11
 * @desription
 */

import com.whut.study.proxy.static_.factory.UsbKingFactory;
import com.whut.study.proxy.static_.service.UsbService;

/**
 * 中介代理商，不让顾客直接和厂家打交道
 */
public class TaoBao implements UsbService {

    private UsbService factory = new UsbKingFactory();


    @Override
    public double sell(int count) {

        //向厂家发送订单,告诉厂家,我买了U盘,厂家发货
        //发送给工厂,我需要的订单,返回报价
        double price = factory.sell(count);
        // 商家需要加价也就是代理要增加价格
        price = price + 25;
        //在目标类的方法调用后,你做的其他功能,都是增强的意思
        System.out.println("淘宝再给你返回一个优惠券,或者红包");
        //增加的价格
        return price;
    }
}
