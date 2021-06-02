package com.whut.algorithm.high.frequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

            if(merged.size() == 0 || merged.get(merged.size()-1)[1] < L){
                merged.add(new int[]{L,R});
            }else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size()-1)[1],R);
            }
        }


        return merged.toArray(new int[merged.size()][]);
    }


    public static void main(String[] args) {

    }
}
