package com.whut.algorithm.high.frequence.problem452_RemoveKDigits;

import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/10 14:48
 * @desription
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    /**
     * 贪心
     *
     * 尽可能一个弓箭穿过多个气球
     *
     * start-end来维护区间
     *
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {

        if(points.length == 0)
            return 0;

        Arrays.sort(points, (o1, o2) -> {
            if(o1[0]>o2[0])
                return 1;
            else if(o1[0]<o2[0])
                return -1;
            return 0;
        });

        int end = points[0][1];
        int person = 1;

        for(int i=1;i<points.length;i++){
            if(points[i][0]>end){
                person++;
                //start = points[i][0];
                end = points[i][1];
            }

//            else
//                start = points[i][0];

            if(points[i][1] < end)
                end = points[i][1];
        }


        return person;
    }

    public static void main(String[] args) {

        //int[][] a = new int[][]{{10,16},{2,8},{1,6},{7,12}};
//        /[1,2],[3,4],[5,6],[7,8]
//        /[1,2],[2,3],[3,4],[4,5]
        //int[][] a = new  int[][]{{1,2},{3,4},{5,6},{7,8}};
        int[][] a = new  int[][]{{2,3},{2,3}};



        System.out.println("person = " + findMinArrowShots(a));

    }

}
