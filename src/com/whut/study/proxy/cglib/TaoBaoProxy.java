package com.whut.study.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/11 16:22
 * @desription
 */
public class TaoBaoProxy implements MethodInterceptor {

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class classz){

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(classz);

        enhancer.setCallback(this);

        return (T)enhancer.create();
    }


    /**
     *
     * 实现原理为继承被代理类
     *
     * @param o
     * @param method 当前类
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
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
}
