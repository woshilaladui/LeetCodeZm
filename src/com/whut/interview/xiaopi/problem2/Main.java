package com.whut.interview.xiaopi.problem2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/6 20:21
 * @desription
 */
public class Main {
    public static void main(String[] args) {

    }

    public long GetNumofExpresss(String express, boolean desired, int index) {
        List<Character> list1 = new LinkedList<>();
        List<Character> list2 = new LinkedList<>();
        char[] arrList = express.toCharArray();

        for (int i = 0; i < arrList.length; i++) {
            if (Character.isDigit(arrList[i])) {
                list1.add(arrList[i]);
            } else {
                list2.add(arrList[i]);
            }
        }

        for (int i = index; i < list2.size(); i++) {
            for (int p = 0; p < list1.size(); p++) {
                for(int q = p+1;q < list1.size();q++){
                    int a = list1.get(p);
                    int b = list1.get(q);
                    list1.remove(a);
                    list1.remove(b);
                    char c = list2.get(i);

                }
            }
        }
        return 0;
    }
}
