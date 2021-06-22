package com.whut.algorithm.high.frequence.offer.problem_offer_03_shu_zu_zhong_zhong_fu_de_shu_zi_lcof;

import java.util.HashSet;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/20 15:28
 * @desription
 */
public class ShuZuZhongZhongFuDeShuZiLcof {

    /**
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     * <p>
     * 空间O(n)
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber1(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        int repeat = -1;

        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }

        return repeat;
    }


    /**
     * 时间O(n)
     * <p>
     * 空间O(1)
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == i)
                continue;
            else if(nums[nums[i]] == nums[i]){
                return nums[i];
            }

            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }

        return -1;

    }

    public String replaceSpace(String s) {
        return s.replaceAll(" ","%20");
    }

    public static void main(String[] args) {
        String s = "cong-wei-dao-tou-da-yin-lian-biao-lcof";
        System.out.println(s.replaceAll("-","_"));
    }
}
