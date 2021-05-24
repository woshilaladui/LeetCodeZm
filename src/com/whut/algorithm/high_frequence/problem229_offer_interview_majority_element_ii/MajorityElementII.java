package com.whut.algorithm.high_frequence.problem229_offer_interview_majority_element_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/24 14:58
 * @desription
 */
public class MajorityElementII {

    /**
     * Moore 投票
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;

        /**
         * 初始化 ，挑选出大于1/3的人至多有2个人
         */
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;

        /**
         * 投票阶段
         */
        for (int num : nums) {

            //先投票
            if (cand1 == num) {
                count1++;
                continue;
            }

            if (cand2 == num) {
                count2++;
                continue;
            }

            //再选谁是优胜者,票数为0要更换cand
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }

            if (count2 == 0) {
                cand2 = num;
                count2++;
                continue;
            }

            count1--;
            count2--;
        }

        /**
         * 最终计票阶段
         */
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == cand1)
                count1++;
            else if (num == cand2)
                count2++;
        }

        if (count1 > nums.length / 3) result.add(cand1);
        if (count2 > nums.length / 3) result.add(cand2);

        return result;
    }

    public static void main(String[] args) {
        MajorityElementII majorityElementII = new MajorityElementII();

        //[1,1,2,2,7,7,8,8,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9,3]
        List<Integer> result = majorityElementII.majorityElement(new int[]{1,1,2,2,7,7,8,8,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9,3});
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}
