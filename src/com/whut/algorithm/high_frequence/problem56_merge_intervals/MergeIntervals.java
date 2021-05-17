package com.whut.algorithm.high_frequence.problem56_merge_intervals;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/13 16:04
 * @desription
 */
public class MergeIntervals {

    /**
     * 如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾；
     * <p>
     * 否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。
     * <p>
     * (1,9),(2,5),(19,20),(10,11),(12,20),(0,3),(0,1),(0,2)
     * <p>
     * (0,3),(0,1),(0,2),(1,9),(2,5),(10,11),(12,20),(19,20)
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {

        //异常判断
        if (intervals.length == 0)
            return new int[0][2];

        //排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];

            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }


        return merged.toArray(new int[merged.size()][]);
    }


    public static void main(String[] args) {
//        int [][]intervals = new int[][]{{1,3},{6,9},{5,6}};
//        int []newInterval = new int[]{2,5};
//
//        int n = intervals.length;
//
//        int [][]temp = new int[n+1][];
//
//        System.arraycopy(intervals,0,temp,0,n);
//        temp[n] = newInterval;
//
//        System.out.println(temp[3][0]);

        TreeSet<Te> treeSet = new TreeSet<>();

        treeSet.add(new Te(3));
        treeSet.add(new Te(2));
        treeSet.add(new Te(1));
        treeSet.add(new Te(6));
        treeSet.add(new Te(5));
        treeSet.add(new Te(4));
        treeSet.add(new Te(7));


        Iterator<Te> iterator = treeSet.tailSet(new Te(-1)).iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next().a);
        }



    }

    public static class Te implements Comparable<Te> {
        int a;

        Te(int a) {
            this.a = a;
        }


        @Override
        public int compareTo(Te o) {
            return this.a - o.a;
        }
    }
}
