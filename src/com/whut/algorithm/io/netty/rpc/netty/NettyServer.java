package com.whut.algorithm.io.netty.rpc.netty;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/15 20:30
 * @desription
 */
public class NettyServer {

    public static void startServer(String hostName, int port) throws InterruptedException {
        startServer0(hostName,port);
    }

    private static void startServer0(String hostname, int port) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(
                            new ChannelInitializer<SocketChannel>() {
                                @Override
                                protected void initChannel(SocketChannel ch) throws Exception {
                                    ChannelPipeline pipeline = ch.pipeline();
                                    pipeline.addLast(new StringDecoder());
                                    pipeline.addLast(new StringEncoder());
                                    pipeline.addLast(new NettyServerHandler()); //业务处理器
                                }
                            }
                    );
            ChannelFuture channelFuture = serverBootstrap.bind(hostname, port).sync();

            System.out.println("服务提供方开始提供服务~~");
            channelFuture.channel().closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

}
