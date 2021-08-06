package com.whut.study.design.pattern.observer;

import sun.reflect.generics.tree.Wildcard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/4 10:31
 * @desription
 */
public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();

        WeixinUser weixinUser1 = new WeixinUser("爱桑");
        WeixinUser weixinUser2 = new WeixinUser("覆盖");
        WeixinUser weixinUser3 = new WeixinUser("苟富贵");

        //订阅
        subscriptionSubject.attach(weixinUser1);
        subscriptionSubject.attach(weixinUser2);
        subscriptionSubject.attach(weixinUser3);

        //发布
        subscriptionSubject.notify("苟富贵的专栏更新了");


    }
}
