package com.whut.algorithm.high.frequence.common.problem470_implement_rand10_using_rand7;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/8 15:29
 * @desription
 */
public class ImplementRand10UsingRand7 {


    public int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7(); // 等概率生成[1,49]范围的随机数
            if (num <= 40) return num % 10 + 1; // 拒绝采样，并返回[1,10]范围的随机数
        }
    }

    private static int rand7() {
        //[x,y]  (y-x+1) + x
        return (int) (Math.random() * 7) + 1;
    }

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(2, "TWO");
        map.put(3, "Three");
        System.out.println(map.get(2));
        System.out.println(map.values());

        map.forEach((k, v) -> {

        });

        Set<Integer> set = map.keySet();

       // List<String> values = (List<String>) map.values();

        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }

        for (String s : list) {
            System.out.println("---------------");
            System.out.println(s);
        }


        for (Map.Entry<Integer, String> integerStringEntry : map.entrySet()) {

        }

//        map.forEach((k,v)->{
//            System.out.println("key : " + k + " value: " + v);
//        });


        BigDecimal a = new BigDecimal("123123213");

        System.out.println(a.hashCode());
    }
}
