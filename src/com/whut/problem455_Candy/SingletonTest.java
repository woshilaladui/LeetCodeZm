package com.whut.problem455_Candy;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/9 20:48
 * @desription
 */
public class SingletonTest {
    private /*volatile*/ static SingletonTest instance = null;
    private SingletonTest() {
        System.out.println(Thread.currentThread().getName()+" --- SingletonTest.SingletonTest --- 私有构造调用了");
    }
    public static SingletonTest getInstance() {
        if(instance == null) {
            synchronized (SingletonTest.class){
                if(instance == null) {
                    instance = new SingletonTest();  //非原子操作
                }
            }
        }
        return instance;
    }
}
