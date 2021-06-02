package com.whut.study.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/11 16:22
 * @desription
 */
public class TaoBaoProxy implements InvocationHandler {

    private Object target;

    public TaoBaoProxy() {
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class classz){

        return (T)Proxy.newProxyInstance(
                classz.getClassLoader(),
                classz.getInterfaces(),
                this
        );

    }

    public TaoBaoProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object res = null;

        //做成通用的
        if(method.getName().equals("sell")){
            res = method.invoke(target, args);

            //在厂家基础上翻倍
            res = (double) res * 2;

            return res;
        }else if(method.getName().equals("repair")){
            res = method.invoke(target, args);

            //修炼在厂家基础上多收10元
            res = (double) res + 10;

            return res;
        }

        return null;
    }
}
