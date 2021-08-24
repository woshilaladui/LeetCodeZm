package com.whut.interview.pdd.problem1_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/22 19:01
 * @desription
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
//        int T, N;
//        Scanner scanner = new Scanner(System.in);
//
//        T = scanner.nextInt();
//
//        for (int i = 0; i < T; i++) {
//            N = scanner.nextInt();
//            List<Goods> list = new ArrayList<>();
//            for (int j = 0; j < N; j++) {
//                Goods goods = new Goods(scanner.nextInt(), scanner.nextInt());
//                list.add(goods);
//            }
//        }
    }

    public static class Goods implements Comparable<Goods> {
        int value;
        int duration;

        public Goods(int value, int duration) {
            this.value = value;
            this.duration = duration;
        }

        @Override
        public int compareTo(Goods o) {
            return (o.value / o.duration) - value / duration;
        }
    }
}
