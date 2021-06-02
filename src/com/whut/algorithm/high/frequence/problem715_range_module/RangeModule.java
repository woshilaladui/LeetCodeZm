package com.whut.algorithm.high.frequence.problem715_range_module;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/5 15:36
 * @desription
 */
public class RangeModule {


    public static void main(String[] args) {
        /**
         * ["RangeModule","
         * queryRange",
         * "queryRange",
         * "addRange",
         * "addRange",
         * "queryRange",
         * "queryRange"
         * ,"queryRange",
         * "removeRange",
         * "addRange",
         * "removeRange",
         *
         * "addRange","
         * removeRange","
         * removeRange",
         * "queryRange",
         * queryRange",
         * "queryRange",
         * "queryRange",
         * "removeRange","
         * addRange","
         * removeRange",
         *
         * "queryRange",
         * "addRange","
         * addRange","
         * removeRange","
         * queryRange",
         * "removeRange",
         * "removeRange","
         * removeRange","
         * addRange","
         * removeRange","
         *
         * addRange
         * queryRange
         * queryRange
         * queryRange
         * queryRange
         * queryRange
         *
         * "addRange","removeRange","addRange","addRange","addRange","queryRange","removeRange","addRange","queryRange","addRange","queryRange","removeRange","removeRange","addRange","addRange","queryRange","queryRange","addRange","addRange","removeRange","removeRange","removeRange","queryRange","removeRange","removeRange","addRange","queryRange","removeRange","addRange","addRange","queryRange","removeRange","queryRange","addRange","addRange","addRange","addRange","addRange","removeRange","removeRange","addRange","queryRange","qu...
         * [[],[21,34],[27,87],[44,53],[69,89],[23,26],[80,84],[11,12],[86,91],[87,94],[34,52],
         * [1,59],[62,96],[34,83],[11,59],[59,79],[1,13],[21,23],[9,61],[17,21],[4,8],
         * [19,25],[71,98],[23,94],[58,95],[12,78],[46,47],[50,70],[84,91],[51,63],[26,64],
         *
         * [38,87],
         * [41,84],
         * [19,21],
         * [18,56],
         * [23,39],
         * [29,95],
         *
         *
         * [79,100],[76,82],[37,55],[30,97],[1,36],[18,96],[45,86],[74,92],[27,78],[31,35],[87,91],[37,84],[26,57],[65,87],[76,91],[37,77],[18,66],[22,97],[2,91],[82,98],[41,46],[6,78],[44,80],[90,94],[37,88],[75,90],[23,37],[18,80],[92,93],[3,80],[68,86],[68,92],[52,91],[43,53],[36,37],[60,74],[4,9],[44,80],[85,93],[56,83],[9,26],[59,64],[16,66],[29,36],[51,96],[56,80],[13,87],[42,72],[6,56],[24,53],[43,71],[36,83],[15,45],[10,48]]
         * ["","","","","","","","","","","","","","","","","queryRange","queryRange","queryRange","queryRange","addRange","removeRange","addRange","addRange","addRange","queryRange","removeRange","addRange","queryRange","addRange","queryRange","removeRange","removeRange","addRange","addRange","queryRange","queryRange","addRange","addRange","removeRange","removeRange","removeRange","queryRange","removeRange","removeRange","addRange","queryRange","removeRange","addRange","addRange","queryRange","removeRange","queryRange","addRange","addRange","addRange","addRange","addRange","removeRange","removeRange","addRange","queryRange","qu...
         * [,[],[],[],[],[1],[],[],[],[],[],[],[],[],[79,100],[76,82],[37,55],[30,97],[1,36],[18,96],[45,86],[74,92],[27,78],[31,35],[87,91],[37,84],[26,57],[65,87],[76,91],[37,77],[18,66],[22,97],[2,91],[82,98],[41,46],[6,78],[44,80],[90,94],[37,88],[75,90],[23,37],[18,80],[92,93],[3,80],[68,86],[68,92],[52,91],[43,53],[36,37],[60,74],[4,9],[44,80],[85,93],[56,83],[9,26],[59,64],[16,66],[29,36],[51,96],[56,80],[13,87],[42,72],[6,56],[24,53],[43,71],[36,83],[15,45],[10,48]]
         *
         * queryRange 21,34
         * queryRange 27,87
         * addRange   44,53
         * addRange   69,89
         * queryRange 23,26
         * queryRange 80,84
         * queryRange 11,12
         * removeRange 86,91
         * addRange 87,94
         * removeRange 34,52
         *
         * addRange [1,59]
         * removeRange 62,96
         * removeRange 34,83
         * queryRange 11,59
         * removeRange 59,79
         * removeRange 1,13
         * queryRange 21,23
         * removeRange 9,61
         * addRange 17,21
         * removeRange 4,8
         *
         * queryRange   19,25
         * addRange   71,98
         * addRange   23,94
         * removeRange   58,95
         * queryRange   12,78
         * removeRange   46,47
         * removeRange   50,70
         * removeRange   84,91
         * addRange   51,63
         * removeRange   26,64
         *
         *
         * addRange    [38,87],
         * queryRange  [41,84],
         * queryRange  [19,21],
         * queryRange  [18,56],
         * queryRange  [23,39],
         * queryRange  [29,95],
         *
         */

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

        /**
         * [17,21)
         * [23,26)
         * [95,98)
         */
//        rangeModule.addRange(17,21);
//        rangeModule.addRange(23,26);
//        rangeModule.addRange(95,98);

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





//        rangeModule.addRange(44,53);
//
//        rangeModule.addRange(69,89);
//        rangeModule.removeRange(86,91);
//        rangeModule.addRange(87,94);
//        rangeModule.removeRange(1,3);
//        rangeModule.addRange(1,8);



       // System.out.println(queryRange(16,17));


    }

    private static TreeSet<Interval> ranges;

    public RangeModule() {
        ranges = new TreeSet<Interval>();
    }

    public void addRange(int left, int right) {
        Iterator<Interval> iterator = ranges.headSet(new Interval(right+1,right+1)).iterator();

        while (iterator.hasNext()) {
            Interval iv = iterator.next();

            if(!(right < iv.left ||left > iv.right)){
                left = Math.min(left, iv.left);
                right = Math.max(right, iv.right);

                iterator.remove();
            }

        }

        ranges.add(new Interval(left,right));
    }

    public static boolean queryRange(int left, int right) {
        Interval iv = ranges.floor(new Interval(left,right));
        return ((iv != null) && (iv.left <= left && right <= iv.right));
    }

    public void removeRange(int left, int right) {
        Iterator<Interval> iterator = ranges.iterator();

        ArrayList<Interval> todoList = new ArrayList<>();

        while (iterator.hasNext()){
            Interval iv = iterator.next();

            if(!(right < iv.left ||left > iv.right)){
                if(left > iv.left)
                    todoList.add(new Interval(iv.left,left));

                if(right < iv.right)
                    todoList.add(new Interval(right,iv.right));

                iterator.remove();
            }

        }
        ranges.addAll(todoList);

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
        return this.left - that.left;
    }
}

