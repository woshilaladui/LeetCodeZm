package com.whut.algorithm.io.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandler;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/14 10:30
 * @desription
 */
public class MyServer {

    public static void main(String[] args) throws InterruptedException {
        //创建两个线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(8);

        //创建引导程序
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        try {
            serverBootstrap
                    .group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline channelPipeline = ch.pipeline();

                            //基于http协议，使用http的编码和解码器
                            channelPipeline.addLast(new HttpServerCodec());

                            //以块的方式写，天骄ChunkedWriteHandler处理器
                            channelPipeline.addLast(new ChunkedWriteHandler());

                            /**
                             * 1. http 数据在传输过程中是分段, HttpObjectAggregator ，就是可以将多个段聚合
                             * 2. 这就就是为什么，当浏览器发送大量数据时，就会发出多次 http 请求
                             */
                            channelPipeline.addLast(new HttpObjectAggregator(8192));

                            /**
                             * 1. 对应 websocket ，它的数据是以 帧(frame) 形式传递
                             * 2. 可以看到 WebSocketFrame 下面有六个子类
                             * 3. 浏览器请求时 ws://localhost:7000/hello 表示请求的 uri
                             * 4. WebSocketServerProtocolHandler 核心功能是将 http 协议升级为 ws 协议 , 保持长连接
                             * 5. 是通过一个 状态码 101
                             */
                            channelPipeline.addLast(new WebSocketServerProtocolHandler("/hello"));

                            //自定义处理器
                            channelPipeline.addLast(new MyTextWebSocketFrameHandler());
                        }
                    });

            ChannelFuture channelFuture = serverBootstrap.bind(7000).sync();

            //监听关闭
            channelFuture.channel().closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
