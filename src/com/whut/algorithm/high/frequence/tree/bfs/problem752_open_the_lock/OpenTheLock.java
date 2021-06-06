package com.whut.algorithm.high.frequence.tree.bfs.problem752_open_the_lock;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/23 16:40
 * @desription
 */
public class OpenTheLock {

    /**
     * 思想 BFS想象转动一次 密码0000 -> 可以得出9000,1000,等8种可能
     * <p>
     * BFS思想，将其抽象成一幅图，每个结点有8个子节点，BFS的取访问这些结点
     * <p>
     * 记录步数，就是最少的次数了
     *
     * @param deadends
     * @param target
     * @return
     */
    private static int openLock(String[] deadends, String target) {

        Set<String> visited = new HashSet<>();

        //初始化
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        Queue<String> queue = new LinkedList<>();

        int step = 0;
        //根节点入队列
        queue.add("0000");
        visited.add("0000");

        //当队列不空时
        while (!queue.isEmpty()) {

            //控制当前这一层被访问完
            int sz = queue.size();

            //一次遍历队列的元素
            for (int i = 0; i < sz; i++) {

                String cur = queue.poll();

                //避开死亡数字集合
                if (dead.contains(cur))
                    continue;

                //判断是否是结果集
                if (cur != null && cur.equals(target))
                    return step;

                //将子节点入队列
                for (int j = 0; j < 4; j++) {

                    String up = upOne(cur, j);

                    //如果没有访问过
                    if (!visited.contains(up)) {
                        queue.add(up);
                        visited.add(up);
                    }

                    String down = downOne(cur, j);

                    if (!visited.contains(down)) {
                        queue.add(down);
                        visited.add(down);
                    }

                }

            }//end for

            step++;
        }//end while


        return -1;
    }

    /**
     * 向上拨动一次
     *
     * @param s
     * @param j
     * @return
     */
    private static String upOne(String s, int j) {

        char[] c_s = s.toCharArray();

        if (c_s[j] == '9')
            c_s[j] = '0';
        else
            c_s[j] += 1;

        return new String(c_s);
    }

    /**
     * 向下拨动一次
     *
     * @param s
     * @param j
     * @return
     */
    private static String downOne(String s, int j) {

        char[] c_s = s.toCharArray();

        if (c_s[j] == '0')
            c_s[j] = '9';
        else
            c_s[j] -= 1;

        return new String(c_s);
    }

    public static void main(String[] args) {

        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};

        String target = "0202";

        System.out.println(openLock(deadends,target));

    }

}
