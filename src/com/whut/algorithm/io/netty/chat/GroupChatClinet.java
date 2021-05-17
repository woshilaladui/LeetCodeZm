package com.whut.algorithm.io.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/8 17:17
 * @desription
 */
public class GroupChatClinet {

    private String host;
    private int port;

    public GroupChatClinet() {
    }

    public GroupChatClinet(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap clientBootstrap = new Bootstrap();

            clientBootstrap
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline channelPipeline = ch.pipeline();

                            channelPipeline.addLast(new StringDecoder());
                            channelPipeline.addLast(new StringEncoder());
                            channelPipeline.addLast(new GroupChatClientHandler());
                        }
                    });

            ChannelFuture channelFuture = clientBootstrap.connect(host, port).sync();

            Channel channel = channelFuture.channel();

            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine()){
                String msg = scanner.nextLine();
                channel.writeAndFlush(msg+"\n");
            }

            //监听关闭
            channel.closeFuture().sync();
        }finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new GroupChatClinet("192.168.222.2",8888).run();
    }
}
