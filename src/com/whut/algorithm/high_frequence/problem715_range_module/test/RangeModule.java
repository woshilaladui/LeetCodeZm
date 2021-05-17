package com.whut.algorithm.high_frequence.problem715_range_module.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/5 17:04
 * @desription
 */
public class RangeModule {

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();




//        rangeModule.addRange(44,53);
//        rangeModule.addRange(69,89);
//        rangeModule.removeRange(86,91);
//        rangeModule.addRange(87,94);
//        rangeModule.removeRange(34,52);
//
//        System.out.println("1111111111111111");
//        Iterator<Interval> iterator1 = ranges.iterator();
//        while (iterator1.hasNext()){
//
//            Interval interval = iterator1.next();
//
//            System.out.println("["+interval.left+","+interval.right+")");
//        }
//
//        System.out.println("1111111111111111");
//
//
//        rangeModule.addRange(1,59);
//        rangeModule.removeRange(62,96);
//        rangeModule.removeRange(34,83);
//        rangeModule.removeRange(59,79);
//        rangeModule.removeRange(1,13);
//        rangeModule.removeRange(9,61);
//        rangeModule.addRange(17,21);
//        rangeModule.removeRange(4,8);
//
//
//        System.out.println("2222222222222");
//        Iterator<Interval> iterator2 = ranges.iterator();
//        while (iterator2.hasNext()){
//
//            Interval interval = iterator2.next();
//
//            System.out.println("["+interval.left+","+interval.right+")");
//        }
//
//        System.out.println("2222222222222");
//
//        rangeModule.addRange(71,98);
//        rangeModule.addRange(23,94);
//        rangeModule.removeRange(58,95);
//        rangeModule.removeRange(46,47);
//        rangeModule.removeRange(50,70);
//        rangeModule.removeRange(84,91);
//        rangeModule.addRange(51,63);
//        rangeModule.removeRange(26,64);


        rangeModule.addRange(6,8);
        rangeModule.removeRange(7,8);
        rangeModule.removeRange(8,9);
        rangeModule.addRange(8,9);
        rangeModule.removeRange(1,3);
        rangeModule.addRange(1,8);
        System.out.println(queryRange(2,4));
        System.out.println(queryRange(2,9));
        System.out.println(queryRange(4,6));

        Iterator<Interval> iterator = ranges.iterator();


        while (iterator.hasNext()){

            Interval interval = iterator.next();

            System.out.println("["+interval.left+","+interval.right+")");
        }

        /**
         * addRange    [38,87],
         * queryRange  [41,84],
         * queryRange  [19,21],
         * queryRange  [18,56],
         * queryRange  [23,39],
         * queryRange  [29,95],
         */
//        rangeModule.addRange(38,87);
//        System.out.println(queryRange(41,84));
//        System.out.println(queryRange(19,21));
//        System.out.println(queryRange(18,56));
//        System.out.println(queryRange(23,39));
//        System.out.println(queryRange(29,95));
    }

    private static TreeSet<Interval> ranges;

    public RangeModule() {
        ranges = new TreeSet();
    }

    public static void addRange(int left, int right) {
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left - 1)).iterator();
        while (itr.hasNext()) {
            Interval iv = itr.next();
            if (right < iv.left) break;
            left = Math.min(left, iv.left);
            right = Math.max(right, iv.right);
            itr.remove();
        }
        ranges.add(new Interval(left, right));
    }

    public static boolean queryRange(int left, int right) {
        Interval iv = ranges.higher(new Interval(0, left));
        return (iv != null && iv.left <= left && right <= iv.right);
    }

    public void removeRange(int left, int right) {
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left)).iterator();
        ArrayList<Interval> todo = new ArrayList();
        while (itr.hasNext()) {
            Interval iv = itr.next();
            if (right < iv.left) break;
            if (iv.left < left) todo.add(new Interval(iv.left, left));
            if (right < iv.right) todo.add(new Interval(right, iv.right));
            itr.remove();
        }
        for (Interval iv : todo) ranges.add(iv);
    }
}


class Interval implements Comparable<Interval> {
    int left;
    int right;

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int compareTo(Interval that) {
        if (this.right == that.right) return this.left - that.left;
        return this.right - that.right;
    }
}

