package com.whut.study.io.rpc;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/20 16:31
 * @desription
 */
public class AobingServiceImpl implements AobingService {
    @Override
    public String hello(String name) {
        return "Yo man Hello，I am" + name;
    }
}
