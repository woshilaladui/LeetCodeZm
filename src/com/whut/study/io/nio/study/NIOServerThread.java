package com.whut.study.io.nio.study;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/15 16:27
 * @desription
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 采用NIO的方式,开启服务线程
 * 该线程存在一个Selector,通道管理器,管理所有的channel
 * step1.服务初始化时,会初始化一个ServerSocektChannel,并注册到Selector中,注册"服务端接收客户端连接"事件
 *
 * step2.之后开启监听,轮询判断Selector上是否有需要处理的事件,如果有则循环处理;
 *
 * step2.1 客户端连接事件:在处理的过程中,获取与客户端连接的通道 socketChannel,并注册到Selector中,通过该通道,与客户端进行读写操作
 *
 * step2.2 读事件,利用读取缓冲区与通道结合进行
 */
public class NIOServerThread extends NIOBase implements Runnable{

    public NIOServerThread(String from, String to) {
        super(from, to);
    }

    //服务端线程中的通道管理器,使用它,可以在同一个线程中管理多个通道

    @Override
    public void run() {
        try {
            initSelector();//初始化通道管理器Selector
            initServer(Constant.IP,Constant.PORT);//初始化ServerSocketChannel,开启监听
            listen();//轮询处理Selector选中的事件
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 获得一个ServerSocket通道,并通过port对其进行初始化
     * @param port    监听的端口号
     */
    private void initServer(String ip,int port) throws IOException {
        //step1. 获得一个ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //step2. 初始化工作
        serverSocketChannel.configureBlocking(false);//设置通道为非阻塞
        serverSocketChannel.socket().bind(new InetSocketAddress(ip,port));

        //step3. 将该channel注册到Selector上,并为该通道注册SelectionKey.OP_ACCEPT事件
        //这样一来,当有"服务端接收客户端连接"事件到达时,selector.select()方法会返回,否则将一直阻塞
        serverSocketChannel.register(this.selector,SelectionKey.OP_ACCEPT);
    }


    /**
     * 当监听到服务端接收客户端连接事件后的处理函数
     * @param key 事件key,可以从key中获取channel,完成事件的处理
     */
    @Override
    public void accept(SelectionKey key) throws IOException {

        //step1. 获取serverSocketChannel
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();

        //step2. 获得和客户端连接的socketChannel
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);//设置为非阻塞

        //step3. 通过socketChannel给客户端发送信息
        socketChannel.write(ByteBuffer.wrap(new String("server has a connection with client").getBytes()));

        //step4. 注册该socketChannel
        socketChannel.register(selector,SelectionKey.OP_READ);//为了接收客户端的消息,注册读事件
    }


}
