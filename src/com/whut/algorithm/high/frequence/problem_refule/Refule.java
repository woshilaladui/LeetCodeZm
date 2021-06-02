package com.whut.algorithm.high.frequence.problem_refule;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/10 16:12
 * @desription
 */
public class Refule {
    /**
     *
     * * 贪心的思想
     *
     * 一直到达不能走的时候在加油，且加区间内能加的最大的油量
     *
     * 用大顶堆每次获取区间最大的油量
     *
     *
     * @param stop stop[0][0] 为当前加油站到终点的距离
     *             stop[0][1] 为当前加油站的油量
     * @param D    起点到终点的距离
     * @param P    当前加油站的油量
     * @return
     */
    private static int fet_minimum_stop(int[][] stop,int D,int P){

        //大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {

                        if(o1 > o2)
                            return -1;
                        else if(o1 < o2)
                            return 1;

                        return 0;
                    }
                }
        );

        int dis;
        //加油的次数
        int result = 0;
        int i;

        for(i=0;i<stop.length;i++){

            dis = D - stop[i][0];

            /**
             * 需要加油
             * 当有油的时候并且当前油量不足够到达下个加油点
             */
            while (!priorityQueue.isEmpty() && P <dis){
                P += priorityQueue.peek();

                priorityQueue.poll();

                result++;

            }

            if(priorityQueue.isEmpty() && P < dis){
                return  -1;
            }
            P = P - dis;

            //更新当前点到终点的距离
            D = stop[i][0];

            //将该点的油量信息插入大顶堆中
            priorityQueue.add(stop[i][1]);
        }


        return result;
    }


    public static void main(String[] args) {


        int[][] stop = new int[][]{{15,2},{11,5},{10,3},{4,4},{0,0}};

        System.out.println(fet_minimum_stop(stop,25,16));

    }

}
