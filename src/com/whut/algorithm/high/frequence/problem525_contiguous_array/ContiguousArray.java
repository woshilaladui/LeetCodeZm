package com.whut.algorithm.high.frequence.problem525_contiguous_array;

import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.DelayQueue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/3 10:58
 * @desription
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {

        /**
         * 原列表:【-1 ,1 ,-1】  (把0看成-1)
         * 前缀列表:【-1 ,0 ,-1】
         * S3-S1 = 0   即 a1+a2+a3-a1 = 0  即 a2+a3=0
         *
         *  第一个位置填0
         * [0,-1,1,-1,1]
         * [0,-1,0,-1,0]
         *  s4 - s0 = a1 ,a2 ,a3, a4
         *
         *  不需要创建出前缀数组s ,用map 来存放前缀和第一次出现的位置（第一次出现后面再出现才是最长）
         *
         */
        //map用于记录第一次出现的前缀和的位置
        HashMap<Integer, Integer> map = new HashMap<>();

        int counter = 0;
        int maxLength = 0;

        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                counter++;
            } else {
                counter--;
            }

            if (map.containsKey(counter)) {
                int preIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - preIndex);
            } else {
                map.put(counter, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
//        ContiguousArray contiguousArray = new ContiguousArray();
//        System.out.println(contiguousArray.findMaxLength(new int[]{0,0,0,1,0,1}));

        HashMap<String,Integer> map = new HashMap<>();

        map.put("abc",12);

        Integer temp = map.put("abc",13);

        System.out.println(temp);
        System.out.println(map.get("abc"));
    }
}
