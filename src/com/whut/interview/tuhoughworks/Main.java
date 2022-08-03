package com.whut.interview.tuhoughworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/12 12:37
 * @desription
 */
public class Main {
    public static int sumofAdjacentElements(List<Integer> array) {
        List<Integer> temp1 = new ArrayList<>(array);
        while (temp1.size() > 2) {
            List<Integer> temp2 = new ArrayList<>();
            for (int i = 0; i < temp1.size(); i++) {
                if (i < temp1.size() - 2) {
                    temp2.add(temp1.get(i) + temp1.get(i + 1));
                    i++;
                } else {
                    if (i == temp1.size() - 1) {
                        temp2.add(temp1.get(i));
                    } else {
                        temp2.add(temp1.get(i) + temp1.get(i + 1));
                        i++;
                    }
                }
            }
            temp1 = temp2;
        }
        if(temp1.size() == 2){
            int x = temp1.get(0);
            int y = temp1.get(1);
            return x*x + y*y;
        }else {
            return temp1.get(0)*temp1.get(0);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(7);


        System.out.println(sumofAdjacentElements(list));
    }
}
