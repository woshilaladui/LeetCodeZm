package com.whut.study.singleton.enum_;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/6 11:08
 * @desription
 */
public class Singleton {
    private Singleton() {
    }

    public static enum SingletonEnum{
        SINGETON;
        private Singleton singleton = null;

        SingletonEnum() {
            singleton = new Singleton();
        }

        public Singleton getInstance(){
            return singleton;
        }
    }
}
