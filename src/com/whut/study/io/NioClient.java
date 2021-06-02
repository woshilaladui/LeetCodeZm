package com.whut.study.io;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/20 16:00
 * @desription
 */
public class NioClient {
    //private static Logger LOGGER = LoggerFactory.getLogger(NioClient.class);
    private static int PORT = 1333;
    private static String[] messages = {"这是服务器"};

    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(InetAddress.getLocalHost(), PORT));
            for (String msg : messages) {
                ByteBuffer myBuffer = ByteBuffer.allocate(1024);
                myBuffer.put(msg.getBytes());
                myBuffer.flip();
                socketChannel.write(myBuffer);
                myBuffer.clear();
                socketChannel.read(myBuffer);
                System.out.println("Client received: " + new String(myBuffer.array()).trim());
            }
            LOGGER.info("Closing Client connection...");
            socketChannel.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            //LOGGER.error(e.getMessage());
        }
    }

}
