package com.whut.algorithm.high.frequence.offer.problem_offer_59_1_hua_dong_chuang_kou_de_zui_da_zhi_lcof;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/30 20:22
 * @desription
 */
public class HuaDongChuangKouDeZuiDaZhiLcof {

    /**
     * 单调队列
     */
    public class MonotonicQueue {

        LinkedList<Integer> queue = new LinkedList<>();

        public void push(int num) {
            while  (!queue.isEmpty() && queue.getLast() < num)
                //注意这不是pollFirst
                // 3 1 2  应该剔除 1 -> 3 2
                queue.pollLast();

            queue.addLast(num);
        }

        public int max() {
            return queue.getFirst();
        }

        public void pop(int num) {
            if (num == queue.getFirst())
                queue.pollFirst();
        }

    }


    public int[] maxSlidingWindow(int[] nums, int k) {

        MonotonicQueue window = new MonotonicQueue();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (i < k - 1) {

                window.push(nums[i]);
            }else {
                window.push(nums[i]);
                result.add(window.max());
                window.pop(nums[i - k + 1]);
            }

        }


        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            arr[i] = result.get(i);

        return arr;
    }

    public static void main(String[] args) {

    }
}
