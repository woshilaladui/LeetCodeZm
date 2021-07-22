package com.whut.algorithm.high.frequence.offer.problem_offer_41_shu_ju_liu_zhong_de_zhong_wei_shu_lcof;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/22 9:45
 * @desription
 */
public class ShuJuLiuZhongDeZhongWeiShuLcof {
    class MedianFinder {
        int count;
        Queue<Integer> maxQueue;
        Queue<Integer> minQueue;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            maxQueue = new PriorityQueue<>((x, y) -> y - x);
            minQueue = new PriorityQueue<>();
            count = 0;
        }

        public void addNum(int num) {
            /**
             * 1. 始终保证大顶堆元素小于小顶堆元素
             * 2. 始终保证大顶堆元素等于小顶堆元素，或者多1
             *      当count 是奇数，则将元素压入  大顶堆 -> 小顶堆 -> 大顶堆
             *      当count 是偶数，则将元素压入  大顶堆 -> 小顶堆
             */
            count++;
            maxQueue.offer(num);
            minQueue.offer(maxQueue.poll());

            //奇数
            if ((count & 1) != 0) {
                maxQueue.offer(minQueue.poll());
            }
        }

        public double findMedian() {

            return (count & 1) == 0 ? (double) (maxQueue.peek() + minQueue.peek())/2: (double)maxQueue.peek();
        }
    }

    public static void main(String[] args) {

    }
}
