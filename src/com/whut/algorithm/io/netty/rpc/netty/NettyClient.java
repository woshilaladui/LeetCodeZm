package com.whut.algorithm.io.netty.rpc.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/15 20:41
 * @desription
 */
public class NettyClient {

    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static NettyClientHandler client;

    private int count = 0;

    public Object getBean(final Class<?> serivceClass, final String providerName) {
        return Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{serivceClass},
                (proxy, method, args) -> {
                    if(client == null)
                        initClient();



                    //设置要发给服务器端的信息
                    //providerName 协议头 args[0] 就是客户端调用 api hello(???), 参数
                    client.setPara(providerName + args[0]);
                    return executor.submit(client).get();
                }
        );
    }

    private static void initClient() throws InterruptedException {
        client = new NettyClientHandler();
        //创建 EventLoopGroup
        NioEventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();

        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(
                        new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ChannelPipeline pipeline = ch.pipeline();
                                pipeline.addLast(new StringDecoder());
                                pipeline.addLast(new StringEncoder());
                                pipeline.addLast(client);

                            }
                        }
                );

        bootstrap.connect("127.0.0.1",7000).sync();



    }

}
