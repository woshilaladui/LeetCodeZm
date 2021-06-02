package com.whut.study.io.reactor;

import java.io.IOException;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/20 19:54
 * @desription
 */
public class ReactorMain {

    public static void main(String[] args) {
        try {
            Reactor reactor = new Reactor(1333);
            reactor.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
