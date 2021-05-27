package com.whut.algorithm.lambda;

import java.util.function.Consumer;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/26 14:49
 * @desription
 */
public class LambdaTest {
    public static void main(String[] args) {
        Service service = (int num)->{
            System.out.println(num+"   a");
        };


        service.sell(10);
    }
}
