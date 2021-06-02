package com.whut.algorithm.high.frequence.slide_window.problem209_minimum_size_subarray_sum;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/20 10:01
 * @desription
 */
public class MinimumSizeSubarraySum {

    /**
     * 求长度的题目可以考虑用滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {

        int left = 0, right = 0;

        int n = nums.length;

        int sum = 0;
        int result = Integer.MAX_VALUE;

        while (right < n) {
            //移入窗口的元素
            int c = nums[right];
            //扩大窗口
            right++;

            //对窗口做更新
            sum += c;

            //判断是否需要缩小窗口
            while (sum >= target) {
                //移除窗口的元素
                int d = nums[left];

                //缩小窗口
                left++;

                sum -= d;
                result = Math.min(result, right - left + 1);


            }

        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int target = 11;
        int[] nums = new int[]{1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(target, nums));
    }
}
