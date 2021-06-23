package com.whut.algorithm.high.frequence.offer.problem_offer_07_chong_jian_er_cha_shu_lcof;

import org.apdplat.word.vector.T;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/22 15:59
 * @desription
 */
public class Test {

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        threadLocal.set(1);
        threadLocal.set(2);

        Thread thread = new Thread(()->{
           threadLocal.set(3);
           threadLocal.set(4);
            System.out.println("thread = "+ threadLocal.get());
        });
        thread.start();
        
        System.out.println(threadLocal.get());
        //System.out.println(threadLocal.get());
    }
}
