package com.whut.study.io.nio.study;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;


/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/15 16:27
 * @desription
 */
public class NIOBase {
    // 线程中的通道管理器
    public Selector selector;
    public String from,to;//server or client

    public NIOBase(String from,String to){
        this.from = from;
        this.to = to;
    }

    /**
     * 初始化 该线程中的通道管理器Selector
     */
    public void initSelector() throws IOException {
        this.selector = Selector.open();
    }


    /**
     * 采用轮询的方式监听selector上是否有需要处理的事件,如果有,则循环处理
     * 这里主要监听连接事件以及读事件
     */
    public void listen() throws IOException {
        //轮询访问select
        while(true){
            //当注册的事件到达时,方法返回;否则将一直阻塞
            selector.select();
            //获得selector中选中的项的迭代器,选中的项为注册的事件
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            //循环处理注册事件
            /**
             * 一共有四种事件:
             * 1. 服务端接收客户端连接事件: SelectionKey.OP_ACCEPT
             * 2. 客户端连接服务端事件:    SelectionKey.OP_CONNECT
             * 3. 读事件:                SelectionKey.OP_READ
             * 4. 写事件:                SelectionKey.OP_WRITE
             */
            while(iterator.hasNext()){
                SelectionKey key = iterator.next();
                //手动删除已选的key,以防重复处理
                iterator.remove();
                //判断事件性质
                if (key.isAcceptable()){//服务端接收客户端连接事件
                    accept(key);
                }else if (key.isReadable()){//读事件
                    read(key);
                }else if (key.isConnectable()) {//客户端连接事件
                    connect(key);
                }
            }
        }
    }

    /**
     * 当监听到读事件后的处理函数
     * @param key 事件key,可以从key中获取channel,完成事件的处理
     */
    public void read(SelectionKey key) throws IOException {
        //step1. 得到事件发生的通道
        SocketChannel socketChannel = (SocketChannel) key.channel();

        //step2. 创建读取的缓冲区.将数据读取到缓冲区中
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        int len = socketChannel.read(byteBuffer);
        String msg = "";
        byte[] arr = null;
        while (len > 0){
            byteBuffer.flip();
            arr = new byte[len];
            byteBuffer.get(arr,0,len);
            msg += new String(arr);
            byteBuffer.clear();
            len = socketChannel.read(byteBuffer);
        }
        System.out.println(from + " received data from " + to + ":" + msg);
        //step3. 再将消息回发给客户端
        if (from.equals("server"))socketChannel.write(ByteBuffer.wrap(new String(" server send some data back to client").getBytes()));
    }

    /**
     * 当监听到服务端接收客户端连接事件后的处理函数
     * @param key 事件key,可以从key中获取channel,完成事件的处理
     */
    public void accept(SelectionKey key) throws IOException{}

    /**
     * 当监听到客户端连接事件后的处理函数
     * @param key 事件key,可以从key中获取channel,完成事件的处理
     */
    public void connect(SelectionKey key) throws IOException{}

}
