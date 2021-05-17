package com.whut.algorithm.io.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/20 19:26
 * @desription
 */
public class Handler implements Runnable{

    private final SelectionKey sk;
    private final SocketChannel sc;

    public Handler(SelectionKey sk, SocketChannel sc) {
        this.sk = sk;
        this.sc = sc;
    }

    @Override
    public void run() {
        //处理业务
        try {
            read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void read() throws IOException{
        byte[] arr = new byte[1024];
        ByteBuffer buf = ByteBuffer.wrap(arr);

        //读取字符串
        int numBytes = sc.read(buf);
        if(numBytes == -1){
            closeChannel();
            return;
        }

        String str = new String(arr);
        if(!str.equals(" ")){
            process(str);
            //根据读取到的数据返回响应
            send(str);
            //使一个阻塞的selector立即返回
            sk.selector().wakeup();
        }
    }

    private void send(String str) throws IOException {
        String returnStr = "服务器响应" + sc.socket().getLocalSocketAddress().toString()+"\r\n";

        ByteBuffer buf = ByteBuffer.wrap(returnStr.getBytes());

        while (buf.hasRemaining()){
            sc.write(buf);
        }

        sk.selector().wakeup();
        System.out.println("send");
    }

    private void process(String str) {
        //处理耗时业务
    }

    private void closeChannel(){
        System.out.println("关闭客户端");
        sk.channel();
        try {
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
