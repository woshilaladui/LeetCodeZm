package com.whut.algorithm.io.netty.rpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/15 20:37
 * @desription
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private ChannelHandlerContext context;//上下文

    private String result; //返回的结果

    private String para; //客户端调用方法时，传入的参数

    //与服务器的连接创建后，就会被调用, 这个方法是第一个被调用(1)
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(" channelActive 被调用");

        context = ctx; //因为我们在其它方法会使用到 ctx
    }

    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(" channelRead 被调用 ");
        result = msg.toString();
        notify(); //唤醒等待的线程
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public Object call() throws Exception {
        System.out.println(" call1 被调用");

        context.writeAndFlush(para);

        wait(); //等待 channelRead 方法获取到服务器的结果后，唤醒

        System.out.println(" call2 被调用 ");

        return result; //服务方返回的结果
    }

    void setPara(String para){
        System.out.println(" setPara ");
        this.para = para;
    }
}
