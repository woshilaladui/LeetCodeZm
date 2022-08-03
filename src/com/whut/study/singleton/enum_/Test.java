package com.whut.study.singleton.enum_;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/10 19:50
 * @desription
 */
public class Test {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.SingletonEnum.SINGETON.getInstance();
        Singleton instance2 = Singleton.SingletonEnum.SINGETON.getInstance();
        System.out.println(instance1 == instance2);
    }
}
