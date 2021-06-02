package com.whut.study.io;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/8 10:59
 * @desription
 */
public class Test {

    public interface  Anbing{
        void say();
    }

    public static class T1Anbling implements Anbing{

        @Override
        public void say() {
            System.out.println("T1Anbling");
        }
    }

    public static class T2Anbling implements Anbing{

        @Override
        public void say() {
            System.out.println("T2Anbling");
        }
    }

    public static void main(String[] args) {
        ServiceLoader<Anbing> serviceLoader = ServiceLoader.load(Anbing.class);

        

        Iterator<Anbing> iterator = serviceLoader.iterator();

        while (iterator.hasNext()){
            System.out.println("a");
            Anbing anbing = iterator.next();
            anbing.say();
        }
    }



}
