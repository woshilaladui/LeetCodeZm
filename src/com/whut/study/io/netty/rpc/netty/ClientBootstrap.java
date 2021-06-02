package com.whut.study.io.netty.rpc.netty;

import com.whut.study.io.netty.rpc.publicinterface.HelloService;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/15 20:48
 * @desription
 */
public class ClientBootstrap {

    //这里定义协议头
    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) throws InterruptedException {

        //创建一个消费者
        NettyClient customer = new NettyClient();

        //创建代理对象
        HelloService service = (HelloService) customer.getBean(HelloService.class, providerName);

        for (; ; ) {
            Thread.sleep(2 * 1000);
            //通过代理对象调用服务提供者的方法(服务)
            String res = service.hello("你好 dubbo~");

            System.out.println("调用的结果 res= " + res);
        }

    }


}
