package com.whut.study.lambda;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/26 14:49
 * @desription
 */
public class ServiceImp implements Service {
    @Override
    public void sell(int num) {
        System.out.println(num);
    }

}
