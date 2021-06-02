package com.whut.study.io.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/20 19:14
 * @desription
 */
public class Reactor implements Runnable {

    private final ServerSocketChannel ssc;
    private final Selector selector;

    public Reactor(int port) throws IOException {
        //打开选择器对象
        selector = Selector.open();
        //打开服务端socket
        ssc = ServerSocketChannel.open();

        InetSocketAddress addr = new InetSocketAddress(port);
        ssc.socket().bind(addr);
        //设置服务的socket为非阻塞
        ssc.configureBlocking(false);
        //将连接对象注册到selector中
        SelectionKey sk = ssc.register(selector,SelectionKey.OP_ACCEPT);

        sk.attach(new Acceptor(ssc,selector));


    }

    @Override
    public void run() {
        try {
            while ( !Thread.interrupted()){
                //从selector选择一个要发生的事件
                selector.select();
                Set selected = selector.selectedKeys();
                Iterator it = selected.iterator();
                while (it.hasNext()) {

                    //分发事件处理
                    dispatch((SelectionKey) (it.next()));
                    it.remove();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dispatch(SelectionKey key){
        // 若是连接事件获取是acceptor
        // 若是IO读写事件获取是handler
        Runnable r = (Runnable) key.attachment();
        if(r != null)
            r.run();
    }
}
