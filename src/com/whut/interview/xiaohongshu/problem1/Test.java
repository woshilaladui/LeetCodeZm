package com.whut.interview.xiaohongshu.problem1;

import java.util.Random;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/4 11:53
 * @desription
 */
public class Test {
    public static void main(String[] args) {
        Random r = new Random();

        if(r.nextInt(10) % 2 == 0){
            System.out.println(7);
        }else {
            System.out.println(6);
        }
    }
}
