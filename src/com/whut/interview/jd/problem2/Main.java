package com.whut.interview.jd.problem2;

import com.whut.algorithm.high.frequence.offer.problem_offer_64_qiu_12n_lcof.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/21 19:54
 * @desription
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
         int N = scanner.nextInt();

        //String str = scanner.next();
        String str = "1010100001";

        char[] arrStr = str.toCharArray();

        for (int i = 1; i < arrStr.length; i++) {
            //int index = i;
            List<Num> list = null;
            int max = 1;
            int part;
            int flag = 0;
            for (part = i; part >= 1; part--) {
                if ((i) % (part) == 0) {
                    list = new ArrayList<>();
                    int step = i / part;

                    //统计几个组
                    for (int k = 0; k < part; k++) {
                        Num num = new Num(0,0);
                        for (int index = step * k +1; index <= step * k + step; index++) {

                            if (arrStr[index] == '0') {
                                ++num.a;
                            } else {
                                ++num.b;
                            }
                        }
                        list.add(num);
                    }

                }
                if(isMax(list)){
                    max = part;
                    System.out.println(max);
                    flag = 1;
                    break;
                }

            }
            if(flag == 0)
                System.out.println(max);

        }

    }

    public static boolean isMax(List<Num> list) {
        Collections.sort(list);
        for (int i = 0; i < list.size()-1; i++) {
            if(!(list.get(i).a.equals(list.get(i + 1).a) && list.get(i).b .equals(list.get(i+1).b))){
                return false;
            }
        }
        return true;
    }

    public static class Num implements Comparable<Num> {
        public Integer a;
        public Integer b;

        public Num(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Num o) {
            return a - o.a;
        }
    }

}
