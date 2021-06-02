package com.whut.study.io.netty.rpc.provider;

import com.whut.study.io.netty.rpc.publicinterface.HelloService;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/15 20:27
 * @desription
 */
public class HelloServiceImp implements HelloService {

    private static int count = 0;

    @Override
    public String hello(String msg) {
        System.out.println("收到客户端消息=" + msg);

        if(msg != null){
            return "你好客户端, 我已经收到你的消息 [" + msg + "] 第" + (++count) + " 次";
        }else {
            return "你好客户端, 我已经收到你的消息 ";
        }
    }
}
