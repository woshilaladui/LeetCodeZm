package com.whut.study.io.netty.chat;


import io.netty.channel.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/8 16:50
 * @desription
 */
public class GroupChatServer {

    private int port;

    public GroupChatServer() {
    }

    public GroupChatServer(int port) {
        this.port = port;
    }

    public void run() throws Exception{

        //创建两个线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(8);

        //创建引导程序
        ServerBootstrap serverBootstrap = new ServerBootstrap();


        try{
            //配置服务端
            serverBootstrap
                    .group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline channelPipeline = ch.pipeline();

                            /**
                             *  若没有加入
                             * StringEncoder,StringDecoder 需要如下手动读写
                             */


//                            @Override
//                            protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//                                //先解码
//                                ByteBuf buf = (ByteBuf) msg;
//                                byte[] request = new byte[buf.readableBytes()];
//                                buf.readBytes(request);
//                                String response = new String(request, "UTF-8");
//                                //编码写入ByteBuf
//                                ByteBuf rep = Unpooled.copiedBuffer(response.getBytes());
//                                ctx.writeAndFlush(rep);
//                            }
                            //向channelPipeline追加解码器
                            channelPipeline.addLast(new StringEncoder());
                            channelPipeline.addLast(new StringDecoder());
                            channelPipeline.addLast(new GroupServerHandler());
                        }
                    });

            System.out.println("netty 服务器启动");


            //绑定端口
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();


            //监听关闭
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }

    public static void main(String[] args) throws Exception {
        new GroupChatServer(7000).run();
    }
}
