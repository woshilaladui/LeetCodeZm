package com.whut.study.function;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/18 15:14
 * @desription
 */
public interface Function1<T,R> {
    public R apply(T t1,T t2);


    public default String s(){
        return "asd";
    }

}
