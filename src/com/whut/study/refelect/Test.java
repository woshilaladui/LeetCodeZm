package com.whut.study.refelect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/10 19:54
 * @desription
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> c = User.class;


        Class[] p = {int.class,String.class};
        Constructor<?> constructor = c.getConstructor(int.class,String.class);

        // Constructor<?> declaredConstructor = c.getDeclaredConstructor(new Class[]{Integer.class, String.class});


        constructor.setAccessible(true);

        System.out.println(constructor.getModifiers());
        User usr = (User) constructor.newInstance(23, "aa");


        System.out.println(usr.toString());

        Method method = c.getDeclaredMethod("say", String.class);




        Field[] field = c.getDeclaredFields();




        method.setAccessible(true);
        method.invoke(usr, "asdasd");

        Method method1 = c.getDeclaredMethod("sayHello",String.class);
        method1.setAccessible(true);
        method1.invoke(usr,"aaaa");




        System.out.println();
    }
}
