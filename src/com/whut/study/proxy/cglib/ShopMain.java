package com.whut.study.proxy.cglib;

import com.whut.study.proxy.cglib.factory.UsbKingFactory;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/11 16:20
 * @desription
 */
public class ShopMain {

    public static void main(String[] args) {


        TaoBaoProxy taoBaoProxy = new TaoBaoProxy();

        UsbKingFactory usbKingFactory = taoBaoProxy.getProxy(UsbKingFactory.class);

        System.out.println(usbKingFactory.sell(10));

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(UsbKingFactory.class);

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object res = null;

                if(method.getName().equals("sell")){
                    res = methodProxy.invokeSuper(o,args);

                    //在厂家基础上翻倍
                    res = (double) res * 2;

                    return res;
                }else if(method.getName().equals("repair")){
                    res = methodProxy.invokeSuper(o,args);

                    //修炼在厂家基础上多收10元
                    res = (double) res + 10;

                    return res;
                }

                return null;
            }
        });

        UsbKingFactory usbKingFactoryProxy = (UsbKingFactory)enhancer.create();

        System.out.println(usbKingFactoryProxy.sell(10));
        System.out.println(usbKingFactoryProxy.repair());

    }
}
