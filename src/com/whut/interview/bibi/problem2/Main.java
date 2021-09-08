package com.whut.interview.bibi.problem2;

import com.whut.algorithm.high.frequence.dynamicPlaning.test.M;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/25 19:30
 * @desription
 */
public class Main {

    static  Main  t = new Main("b");
    static {
        System.out.print("g");
    }
    Value value = new Value("r");
//
    {
        System.out.print("q");
    }


    //Main a = new Main("a");

    public Main() {
    }

    public Main(String s) {
        System.out.print(s);
    }

    public static void main(String[] args) {


//        new Main("l");
    }

    public class Value{
        public Value(String s){
            System.out.print(s);
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                    5,
                    10,
                    10L,
                    TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(10),
                    new ThreadPoolExecutor.CallerRunsPolicy()
            );

        }
    }
}

