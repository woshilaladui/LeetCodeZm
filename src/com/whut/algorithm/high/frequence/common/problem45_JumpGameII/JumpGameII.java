package com.whut.algorithm.high.frequence.common.problem45_JumpGameII;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/9 19:09
 * @desription
 */
public class JumpGameII {

    /**
     * 通过大顶堆来维护
     * @param nums
     * @return
     */
    private static int jump2(int[] nums){

        int step = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if(o1 > o2)
                    return -1;
                else if(o1 < o2)
                    return 1;
                return 0;
            }
        });

        //用来保存下一次起跳能到的最远位置
        int end = 0;
        //现在的位置
        int now = 0;

        int max = 0;


        while (end < nums.length -1){
            priorityQueue.add(nums[now]+  now);
            max = priorityQueue.peek() ;

            if(now == end){
                step ++;
                end = max;
            }

            now++;
        }

        return step;
    }

    private static int jump(int[] nums) {
        int step = 0;
        //用来保存下一次起跳能到的最远位置
        int end = 0;
        //遍历的下标
        int now = 0;
        //最大能到达的位置，这个是在遍历过程不断更新的
        int max_pos = 0;

        while (end < nums.length - 1) {

            max_pos = Math.max(max_pos, nums[now] + now);

            if (now == end) {
                step++;
                end = max_pos;
            }
            now++;

        }
        return step;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2,3,1,1,4};

        System.out.println(jump2(nums));



    }
}
