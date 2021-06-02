package com.whut.algorithm.high.frequence.problem57_insert_interval;

import com.whut.algorithm.dynamicPlaning.test.M;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/15 17:02
 * @desription
 */
public class InsertInterval {

    public static int[][] insert2(int[][] intervals, int[] newInterval){
        int L = newInterval[0];
        int R = newInterval[1];
        
        boolean flag = false;
        
        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            if(interval[0] > R){
                if(!flag){
                    result.add(new int[]{L,R});
                    flag = true;
                }
                result.add(interval);
            }else if(interval[1] < L){
                result.add(interval);
            }else {
                //计算交集
                L = Math.min(L,interval[0]);
                R = Math.max(R,interval[1]);
            }
        }

        if(!flag)
            result.add(new int[]{L,R});

        return result.toArray(new int[result.size()][]);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int lenIntervals = intervals.length;

        int[][] tempIntervals = new int[lenIntervals + 1][];

        System.arraycopy(intervals,0,tempIntervals,0,lenIntervals);

        tempIntervals[lenIntervals] = newInterval;


        return merge(tempIntervals);
    }
    public static int[][] merge(int[][] intervals){

        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals);

        for (int i = 0; i < intervals.length; i++) {

            int L = intervals[i][0];
            int R = intervals[i][1];

            if(result.size() ==0 || result.get(result.size()-1)[1] < L){
                result.add(new int[]{L,R});
            }else {
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1],R);
            }


        }

        return result.toArray(new int[result.size()][]);
    }


    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(5);
        treeSet.add(7);
        treeSet.add(9);

        Iterator<Integer> iterator = treeSet.headSet(5).iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
