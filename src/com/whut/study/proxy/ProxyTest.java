package com.whut.study.proxy;

import com.whut.algorithm.high.frequence.dynamicPlaning.sub_string.Test;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/4 15:42
 * @desription
 */
public class ProxyTest {

    interface Speaker{
        public void speak();
    }

    static class ZhangSan implements Speaker{

        @Override
        public void speak() {
            System.out.println("我老婆打我");
        }
    }

    static class ZhangSanLawyer implements Speaker{

        private ZhangSan zhangSan = new ZhangSan();

        @Override
        public void speak() {
            System.out.println("引用法律条纹");
            zhangSan.speak();
            System.out.println("打人是不对的");
        }
    }

    static class LawyerProxy implements InvocationHandler{

        Object obj;

        public LawyerProxy(Object obj) {
            this.obj = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //如果是speak方法则调用
            if(method.getName().equals("speak")){
                System.out.println("引用法律条纹");
                //反射调用obj的speak方法
                method.invoke(obj,args);
                System.out.println("打人是不对的");
            }
            return null;
        }
    }

    static class LawyerInteceptor implements MethodInterceptor{

        Object obj;


        public LawyerInteceptor(Object obj) {
            this.obj = obj;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            //如果是speak方法则调用
            if(method.getName().equals("speak")){
                System.out.println("引用法律条纹");
                //反射调用obj的speak方法
            //    method.invoke(obj,args);
                methodProxy.invokeSuper(obj,args);
                //methodProxy.invokeSuper()
                System.out.println("打人是不对的");
            }
            return null;
        }
    }

    public static class LiSi{
        public void speak(){
            System.out.println("我老婆打我");
        }
    }


    public static void main(String[] args) {
        //静态代理
        System.out.println("---静态代理---");
        Speaker speaker = new ZhangSanLawyer();
        speaker.speak();

        System.out.println("------");

        //JDK动态代理 本体必须要用接口
        System.out.println("---JDK动态代理---");
        LawyerProxy lawyerProxy = new LawyerProxy(new ZhangSan());
        Speaker speaker1 = (Speaker) Proxy.newProxyInstance(Test.class.getClassLoader(),new Class[]{Speaker.class},lawyerProxy);
        speaker1.speak();
        System.out.println("------");

        //CGLib_动态代理 JDK代理的补充，不要求本体实现接口
        System.out.println("---CGLib 动态代理---");
        LawyerInteceptor lawyerInteceptor = new LawyerInteceptor(new LiSi());
        LiSi liSi = (LiSi) Enhancer.create(LiSi.class,lawyerInteceptor);
        liSi.speak();
        System.out.println("------");

    }


}
