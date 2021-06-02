package com.whut.study.io.reactor;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/20 19:24
 * @desription
 */
public class Acceptor implements Runnable {

    private final ServerSocketChannel ssc;
    private final Selector selector;

    public Acceptor(ServerSocketChannel ssc, Selector selector) {
        //服务端socket
        this.ssc = ssc;
        //选择器对象
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            SocketChannel sc = ssc.accept();

            System.out.println(sc.socket().getRemoteSocketAddress().toString()+"is connected");

            if(sc != null){
                //设置客户端非阻塞
                sc.configureBlocking(false);
                //注册读写事件
                SelectionKey sk = sc.register(selector,SelectionKey.OP_READ);
                //给定key一个附加对象Handler
                sk.attach(new Handler(sk,sc));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
