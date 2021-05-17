package com.whut.algorithm.io.netty.rpc.provider;

import com.whut.algorithm.io.netty.rpc.netty.NettyServer;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/15 20:29
 * @desription
 */
public class ServerBootstrap {

    //ServerBootstrap 会启动一个服务提供者，就是 NettyServer
    public static void main(String[] args) throws InterruptedException {
        NettyServer.startServer("127.0.0.1", 7000);
    }

}
