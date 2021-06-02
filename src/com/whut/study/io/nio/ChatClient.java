package com.whut.study.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/5 15:49
 * @desription
 */
public class ChatClient {


    private SocketChannel socketChannel;
    private Selector selector;

    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);

    private static final Charset CHARSET = Charset.forName("UTF-8");

    public ChatClient() {
    }

    public ChatClient(String host, int port) {
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress(host, port));


            while (!socketChannel.finishConnect())
                System.out.println("正在等待连接");

            System.out.println("连接成功");

            selector = Selector.open();

            socketChannel.register(selector, SelectionKey.OP_READ);

            new Thread(new Handler(selector)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 给服务器发消息
     */
    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (null != line && !"".equals(line.trim())) {
                if(line.equals("*")){
                    socketChannel.close();
                    //break;
                }else if(line.equals("&")){
                    System.out.println("hhhhhh");
                    ChatClient chatClient = new ChatClient("127.0.0.1", 9000);
                    chatClient.start();
                }else {
                    socketChannel.write(CHARSET.encode(line));
                }


            }
        }
    }

    /**
     * 接收来自服务器的消息
     */
    class Handler implements Runnable {

        private Selector selector;

        public Handler(Selector selector) {
            this.selector = selector;
        }

        @Override
        public void run() {
            try {
                while (true) {

                    int readyChannels = selector.selectNow();

                    if (readyChannels == 0) continue;

                    Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

                    while (keyIterator.hasNext()) {

                        SelectionKey key = keyIterator.next();

                        if (key.isReadable()) {
                            SocketChannel socketChannel = (SocketChannel) key.channel();

                            String msg = "";
                            while (socketChannel.read(readBuffer) > 0) {
                                //  从写模式切换为读模式
                                readBuffer.flip();
                                msg += CHARSET.decode(readBuffer);
                            }
                            System.out.println(msg);
                            readBuffer.clear();
                        }

                        keyIterator.remove();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        ChatClient chatClient = new ChatClient("127.0.0.1", 9000);
        chatClient.start();
    }
}
