package com.whut.study.proxy.jdk;

import com.whut.study.proxy.jdk.factory.UsbKingFactory;
import com.whut.study.proxy.jdk.service.UsbService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/11 16:20
 * @desription
 */
public class ShopMain {

    public static void main(String[] args) {
        /**
         * jdk的动态代理需要被代理的类实现接口
         */




        //被代理的对象
        UsbService factory = new UsbKingFactory();

        //动态构建代理类
        TaoBaoProxy myHandler = new TaoBaoProxy(factory);

        UsbService proxy = myHandler.getProxy(factory.getClass());

        System.out.println(proxy.sell(10));

        UsbService usbService = (UsbService) Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(), myHandler);

        System.out.println(usbService.sell(1));

        System.out.println(usbService.repair());

        /**
         * 不构建出TaoBaoProxy
         *  隐示调用
         */
        UsbService usbService1 = (UsbService) Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object res = null;
                //做成通用的
                if (method.getName().equals("sell")) {
                    res = method.invoke(factory, args);

                    //在厂家基础上翻倍
                    res = (double) res * 2;

                    return res;
                } else if (method.getName().equals("repair")) {
                    res = method.invoke(factory, args);

                    //修炼在厂家基础上多收10元
                    res = (double) res + 10;

                    return res;
                }

                return null;
            }
        });

        System.out.println("------------不构建出InvocationHandler 的实现类，动态构建");
        System.out.println(usbService1.sell(2));
        System.out.println(usbService1.repair());


    }
}
