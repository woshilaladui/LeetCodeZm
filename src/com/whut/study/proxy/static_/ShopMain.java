package com.whut.study.proxy.static_;

import com.whut.study.proxy.static_.business.TaoBao;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/11 16:14
 * @desription
 */
public class ShopMain {
    public static void main(String[] args) {
        //创建代理的商家淘宝对象
        TaoBao taoBao = new TaoBao();
        //我只向淘宝买一件产品,得到报价
        double price = taoBao.sell(2);
        System.out.println("购买一件产品.淘宝的报价为: "+price);
    }
}
