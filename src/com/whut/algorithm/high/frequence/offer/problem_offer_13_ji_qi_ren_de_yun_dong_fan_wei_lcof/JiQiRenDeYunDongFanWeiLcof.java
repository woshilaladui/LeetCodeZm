package com.whut.algorithm.high.frequence.offer.problem_offer_13_ji_qi_ren_de_yun_dong_fan_wei_lcof;

import com.whut.study.io.netty.chat.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/25 9:13
 * @desription
 */
public class JiQiRenDeYunDongFanWeiLcof {

    private static int[][] directions = new int[][]{
            {0, 1},//右
            {1, 0},//下
            {0, -1},//左
            {-1, 0}//上
    };

    /**
     * 这样写是错误的，直接暴力写 如:
     *
     * m = 16, n = 8 k = 4
     *
     *  它在之前肯定到过(5,0)
     *  机器人到不了(10,0)这个点
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount1(int m, int n, int k) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(isSmallerK(i,j,k)){
                    System.out.println("x = " + i + "  y = " + j);
                    count++;
                }

            }
        }
        return count;
    }


    public int movingCount(int m, int n, int k) {

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        List<String> list = new ArrayList<>();

        backTrack(m, n, 0, 0, visited, k, list);

        return list.size() + 1;
    }

    private void backTrack(int m, int n, int x, int y, boolean[][] visited, int k, List<String> list) {

        //结束条件
        if (!isSmallerK(x, y, k))
            return;

        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];

            //判断是否越界
            if (newX < 0 || newX >= m || newY < 0 || newY >= n)
                continue;

            if (visited[newX][newY])
                continue;

            if (isSmallerK(newX, newY, k)) {
                //count++;
                visited[newX][newY] = true;
                list.add("x = " + newX + "  y = " + newY);
                System.out.println("x = " + newX +"  y = " + newY);
                backTrack(
                        m,
                        n,
                        newX,
                        newY,
                        visited,
                        k,
                        list
                );
                //不需要标记访问过，因为该结点已经判定过结果了
                //visited[newX][newY] = false;
            }
        }
    }

    private boolean isSmallerK(int x, int y, int k) {

        int resultX = 0;
        int resultY = 0;

        while (x != 0) {
            resultX += x % 10;
            x /= 10;
        }

        while (y != 0) {
            resultY += y % 10;
            y /= 10;
        }

        return (resultX + resultY) <= k;
    }

    public static void main(String[] args) {
        JiQiRenDeYunDongFanWeiLcof jiQiRenDeYunDongFanWeiLcof = new JiQiRenDeYunDongFanWeiLcof();


        //System.out.println(jiQiRenDeYunDongFanWeiLcof.isSmallerK(35,38,18));
        int m = 16;
        int n = 8;
        int k = 4;
        System.out.println("count = "+jiQiRenDeYunDongFanWeiLcof.movingCount(m, n, k));

        /**
         * x = 0  y = 1
         * x = 1  y = 1
         * x = 2  y = 1
         * x = 2  y = 0
         * x = 1  y = 0
         */
    }
}
