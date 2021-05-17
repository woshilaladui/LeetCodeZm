package com.whut.algorithm.function;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/18 15:15
 * @desription
 */
public class Function1Imp implements Function1<String,Integer> {
    @Override
    public Integer apply(String s,String s2) {
        return s.length();
    }


    public Integer apply2(String s,Integer a){
        return s.length();
    }
}
