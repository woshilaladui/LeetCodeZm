package com.whut.interview.tuhoughworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/12 12:55
 * @desription
 */
public class Main3 {
    public static List<Integer> evenTheOdds(List<Integer> array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            int x = array.get(i);
            if(x % 2 ==0){
                list.add(x);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6,7,12,32,43);
        List<Integer> result = evenTheOdds(list);
        for (Integer integer : result) {
            System.out.print(integer+" ");
        }
    }
}
