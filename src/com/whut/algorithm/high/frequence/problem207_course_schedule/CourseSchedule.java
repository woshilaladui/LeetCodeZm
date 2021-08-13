package com.whut.algorithm.high.frequence.problem207_course_schedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/13 20:06
 * @desription
 */
public class CourseSchedule {

    /**
     * top排序
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //边集合
        /**
         *
         * 0  1 2 3  说明有边 0->1 0->2 0->3
         * 1  2 4 6
         */
        List<List<Integer>> edges = new ArrayList<>();

        int[] indeg;

        for (int i = 0; i < numCourses; i++)
            edges.add(new ArrayList<>());

        indeg = new int[numCourses];
        /**
         * 初始化
         */
        for (int[] info : prerequisites) {
            // info[1] -> info[0]
            edges.get(info[1]).add(info[0]);
            //入度++
            indeg[info[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        //将入度为0的结点入队列
        for (int i = 0; i < numCourses; i++)
            if (indeg[i] == 0){
                queue.offer(i);
            }


        int vis = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            vis++;

            //遍历u的连接的结点，将他们入度-1，在检查是否为0
            for(int v:edges.get(u)){
                indeg[v]--;
                if(indeg[v] == 0)
                    queue.offer(v);
            }
        }

        return numCourses == vis;
    }

    public static void main(String[] args) {

    }
}
