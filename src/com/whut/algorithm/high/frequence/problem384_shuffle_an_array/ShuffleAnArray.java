package com.whut.algorithm.high.frequence.problem384_shuffle_an_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/16 9:52
 * @desription
 */
public class ShuffleAnArray {

    public class Solution {

        private int[] array;
        private int[] original;

        private Random random;

        public Solution(int[] nums) {
            this.array = nums;
            this.original = this.array.clone();
            random = new Random();
        }

        private List getArrayList(int[] nums) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }

            return list;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            this.array = this.original.clone();
            original = original.clone();
            return array;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {

            List<Integer> list = getArrayList(this.array);

            for (int i = 0; i < array.length; i++) {
                int removeIndex = random.nextInt(list.size());

                array[i] = list.get(removeIndex);

                list.remove(removeIndex);
            }

            return array;
        }
    }


    public static void main(String[] args) {

    }
}
