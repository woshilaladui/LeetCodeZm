package com.whut.algorithm.high.frequence.monotonic_queue.problem239_sliding_window_maximum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/14 15:24
 * @desription
 */
public class MonotonicQueue {

    LinkedList<Integer> queue = new LinkedList<>();

    public void push(int num) {
        while (!queue.isEmpty() && queue.getLast() < num) {
            queue.pollLast();
        }

        queue.addLast(num);
    }

    public int max() {
        return queue.getFirst();
    }

    public void pop(int n) {
        if (n == queue.getFirst())
            queue.pollFirst();
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {

        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //先填满窗口的前k-1个
                window.push(nums[i]);
            } else {
                //窗口向前滑动，加入新的数字
                window.push(nums[i]);
                //记录窗口最大值
                res.add(window.max());
                //移除旧数据
                window.pop(nums[i - k + 1]);
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            arr[i] = res.get(i);

        return arr;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] result = maxSlidingWindow(nums,k);
        for (int i : result) {
            System.out.print(i+" ");
        }

    }
}
