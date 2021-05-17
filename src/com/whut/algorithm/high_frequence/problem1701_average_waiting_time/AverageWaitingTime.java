package com.whut.algorithm.high_frequence.problem1701_average_waiting_time;

import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/31 20:28
 * @desription
 */
public class AverageWaitingTime {

    public static double averageWaitingTime(int[][] customers) {

        //上个人结束的时间
        int endTime = 0;
        double sumTime = 0;

        int n = customers.length;

        Arrays.sort(customers,(o1, o2) -> {return o1[0]-o2[0];});

        for (int i = 0; i < n; i++) {
            //如果当前客人来的时间在上个客人之后
            if(endTime < customers[i][0]){
                endTime = customers[i][0] + customers[i][1];
            }else {
                endTime = endTime + customers[i][1];
            }

            sumTime = sumTime + endTime - customers[i][0];
        }

        return sumTime/customers.length;
    }

    public static void main(String[] args) {

    }
}
