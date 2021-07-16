package com.whut.study.io.nio.study;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/15 16:30
 * @desription
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * NIO 客户端线程
 */
public class NIOClientThread extends NIOBase implements Runnable{


    private String ip;

    public NIOClientThread(String from, String to) {
        super(from, to);
        ip = Constant.IP;
    }

    public NIOClientThread(String from,String to,String ip){
        super(from,to);
        this.ip = ip;
    }
    @Override
    public void run() {
        try {
            initSelector();//初始化通道管理器
            initClient(ip,Constant.PORT);//初始化客户端连接scoketChannel
            listen();//开始轮询处理事件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得一个SocketChannel,并对该channel做一些初始化工作,并注册到
     * @param ip
     * @param port
     */
    private void initClient(String ip,int port) throws IOException {
        //step1. 获得一个SocketChannel
        SocketChannel socketChannel = SocketChannel.open();

        //step2. 初始化该channel
        socketChannel.configureBlocking(false);//设置通道为非阻塞


        //step3. 客户端连接服务器,其实方法执行并没有实现连接,需要再listen()方法中调用channel.finishConnect()方法才能完成连接
        socketChannel.connect(new InetSocketAddress(ip,port));

        //step4. 注册该channel到selector中,并为该通道注册SelectionKey.OP_CONNECT事件和SelectionKey.OP_READ事件
        socketChannel.register(this.selector,SelectionKey.OP_CONNECT|SelectionKey.OP_READ);
    }

    /**
     * 当监听到客户端连接事件后的处理函数
     * @param key 事件key,可以从key中获取channel,完成事件的处理
     */
    @Override
    public void connect(SelectionKey key) throws IOException {
        super.connect(key);
        //step1. 获取事件中的channel
        SocketChannel socketChannel = (SocketChannel) key.channel();

        //step2. 如果正在连接,则完成连接
        if (socketChannel.isConnectionPending()){
            socketChannel.finishConnect();
        }
        socketChannel.configureBlocking(false);//将连接设置为非阻塞
        //step3. 连接后,可以给服务端发送消息
        socketChannel.write(ByteBuffer.wrap(new String("client send some data to server").getBytes()));

    }
}
