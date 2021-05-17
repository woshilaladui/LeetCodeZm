package com.whut.algorithm.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/20 16:00
 * @desription
 */
public class NioServer implements Runnable {
    //private static Logger LOGGER = LoggerFactory.getLogger(NioServer.class);
    @Override
    public void run() {
        try {
            //1、打开ServerSocketChannel，监听客户端的链接
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            //2、绑定监听端口,设置backlog（默认50）:请求传入连接队列的最大长度
            serverSocket.socket().bind(new InetSocketAddress(1333), 1024);
            //3、false,设置为非阻塞模式
            serverSocket.configureBlocking(false);
            //4、创建Selector，Selector是NIO的多路复用器，Selector会不断轮询注册在它上面的通道Channel,
            //找出就绪状态的Channel(Channel通道发生读、写事件)。
            Selector selector = Selector.open();
            //5、注册通道Channel到多路复用器Selector，并说明关注点SelectionKey.OP_ACCEPT，监听ACCEPT事件
            SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);



            System.out.println("Listening on port {}" +9011);

            //6、Selector轮询就绪的Channel
            while (true) {
                // 阻塞等待就绪的 Channel，这是关键点之一
                //selector 1秒被唤醒
//                int n = selector.select(1000);
//                if (n == 0) {
//                    continue;
//                }
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();


                System.out.println("size = "+selectedKeys.size());
                Iterator<SelectionKey> iter = selectedKeys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    if (key.isValid()) {

                        if (key.isAcceptable()) {
                            //SelectionKey可以获取就绪状态的Channel
                            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                            //7、多路复用器Selector监听到有新的客户端连接，完成TCP三次握手建立连接。
                            SocketChannel clientSocketChannel = serverSocketChannel.accept();
                            //8、设置客户端SocketChannel为非阻塞模式
                            clientSocketChannel.configureBlocking(false);
                            //9、注册加入新的通道OP_READ
                            clientSocketChannel.register(selector, SelectionKey.OP_READ);
                        }

                        //读取客户端数据
                        //if(key.isReadable())等价于if((key.readyOps( ) & SelectionKey.OP_READ) != 0)
                        if (key.isReadable()) {
                            System.out.println("aaa");
                            SocketChannel socketChannel = (SocketChannel) key.channel();
                            //创建buffer
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                            int readPosition = socketChannel.read(readBuffer);
                            if (readPosition > 0) {
                                //flip()方法，Buffer从写模式切换到读模式,将limit设置为position，position设为0。
                                readBuffer.flip();
                                byte[] bytes = new byte[readBuffer.remaining()];
                                //从可读buffer中读取数据
                                readBuffer.get(bytes);
                                System.out.println("接收客户端发送消息：{}"+ new String(bytes, StandardCharsets.UTF_8));

                                byte[] sendBytes = "server 收到".getBytes();
                                ByteBuffer writeBuffer = ByteBuffer.allocate(10240);
                                //writeBuffer.flip();
                                System.out.println("sendBytes1 = "+ sendBytes);
                                writeBuffer.put(sendBytes);
                                //put 向buffer添加元素
//                                while (writeBuffer.remaining() > 0) {
//                                    writeBuffer.put(sendBytes);
//                                    System.out.println("sendBytes 2= "+ sendBytes);
//                                }

                                socketChannel.write(writeBuffer);
                            }

                            System.out.println("readPosition = " + readPosition);

                            if (readPosition < 0) {
                                // Close channel on EOF, invalidates the key
                                System.out.println("关闭");
                                key.cancel();
                                socketChannel.close();
                            }
                        }
                    }
                    iter.remove();

                    System.out.println(iter.hasNext());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new NioServer()).start();
    }
}
