package com.whut.algorithm.high.frequence.offer.problem_114_flatten_binary_tree_to_linked_list;

import java.net.URLClassLoader;
import java.security.SecureClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/13 10:11
 * @desription
 */
public class Test {
    public static void main(String[] args) {
        String c = "10";
        System.out.println(getInt(c));
        System.out.println(c);
    }

    public static int getInt(String c) {
        Integer a = 10;
        try {
            System.out.println(a / 0);
            a = 20;
        } catch (ArithmeticException e) {
            a = 30;
            return a;
            /*
             * return a 在程序执行到这一步的时候，这里不是return a 而是 return 30；这个返回路径就形成了
             * 但是呢，它发现后面还有finally，所以继续执行finally的内容，a=40
             * 再次回到以前的路径,继续走return 30，形成返回路径之后，这里的a就不是a变量了，而是常量30
             */
        } finally {
            a = 40;
            c = "asd";
            ArrayList<Integer> list = new ArrayList<>();
            ReentrantLock lock = new ReentrantLock();
        }

//      return a;
        return 1;
    }
}
