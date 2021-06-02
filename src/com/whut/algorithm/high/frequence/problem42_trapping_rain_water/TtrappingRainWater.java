package com.whut.algorithm.high.frequence.problem42_trapping_rain_water;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/2 10:14
 * @desription
 */
public class TtrappingRainWater {

    /**
     * [0,1,0,2,1,0,1,3,2,1,2,1]
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        //维护一个单调栈，栈顶到栈底一次减少
        //存放数组下标
        Stack<Integer> stack = new Stack<>();

        int result = 0;

        for (int i = 0; i < height.length; i++) {
            //可以形成接水区域
            while (!stack.empty() && height[i] > height[stack.peek()]) {

                int pop = stack.pop();

                if (stack.empty())
                    break;

                int left = stack.peek();

                int w = i - left - 1;
                int h = Math.min(height[left], height[i]) - height[pop];

                result += w * h;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        TtrappingRainWater ttrappingRainWater = new TtrappingRainWater();

        System.out.println(ttrappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
