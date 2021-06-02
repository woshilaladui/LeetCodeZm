package com.whut.study.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/5 15:15
 * @desription
 */
public class ChatServer {

    private ServerSocketChannel serverSocketChannel;

    private Selector selector;


    private ByteBuffer writeBuffer;
    private ByteBuffer readBuffer;

    private static final Charset CHARSET = Charset.forName("UTF-8");

    public ChatServer() {
    }

    public ChatServer(int port) {
        try {
            writeBuffer = ByteBuffer.allocate(1024);
            readBuffer = ByteBuffer.allocate(1024);
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(port));

            serverSocketChannel.configureBlocking(false);

            selector = Selector.open();


            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public void listen() throws IOException {

        System.out.println("服务器启动成功");

        while (true){
            //轮询就绪的Channel
            selector.select();

            Set<SelectionKey> selectedKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectedKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isValid()) {
                    if (key.isAcceptable()) {
                        SocketChannel clientSocketChannel = serverSocketChannel.accept();

                        clientSocketChannel.configureBlocking(false);
                        clientSocketChannel.register(selector, SelectionKey.OP_READ);
                        clientSocketChannel.write(CHARSET.encode("来自服务器的问候：你好"));
                    }

                    if (key.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();

                        String msg = "";

                        int readPosition = socketChannel.read(readBuffer);
                        if (readPosition > 0) {
                            readBuffer.flip();
                            byte[] bytes = new byte[readBuffer.remaining()];
                            //从可读buffer中读取数据
                            readBuffer.get(bytes);
                            System.out.println("接收客户端发送消息：{}"+ new String(bytes, StandardCharsets.UTF_8));


                            readBuffer.clear();

                            byte[] sendBytes = "server 收到".getBytes();

                            //System.out.println("sendBytes1 = "+ sendBytes);
                            writeBuffer.put(sendBytes);
                            writeBuffer.flip();

                            socketChannel.write(writeBuffer);
                            writeBuffer.clear();
                        }

                        if (readPosition < 0) {
                            // Close channel on EOF, invalidates the key
                            System.out.println("关闭");
                            key.cancel();
                            socketChannel.close();
                        }

                    }
                }


                iterator.remove();
            }
        }


    }

    public static void main(String[] args) throws IOException {
        ChatServer chatServer = new ChatServer(9000);
        chatServer.listen();
    }
}
