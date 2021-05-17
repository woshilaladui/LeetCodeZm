package com.whut.algorithm.io.netty.chat;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/10 21:18
 * @desription
 */
public class Test {

    public static class List{
        public int val;
        public List next;
    }

    static List left = new List();

    public static void main(String[] args) {
        List list1 = new List();
        List list2 = new List();
        List list3 = new List();
        List list4 = new List();
        List list5 = new List();
        list1.val = 1;
        list2.val = 2;
        list3.val = 3;
        list4.val = 2;
        list5.val = 1;

        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;

        left = list1;
        System.out.println(isP(list1));

    }



    private static boolean isP(List right){

        if(right == null)
            return true;

        boolean res = isP(right.next);

        res = res && (left.val == right.val);

        left = left.next;


        return res;
    }
}
