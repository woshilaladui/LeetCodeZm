package com.whut.algorithm.high.frequence.problem_offer_17_10_find_majority_element_lcci;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/24 15:18
 * @desription
 */
public class FindMajorityElementLcci {


    /**
     * 输入：[1,2,5,9,5,9,5,5,5]
     * 输出：5
     *
     * Moore投票的思想
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        int cand = nums[0], count = 0;

        /**
         * 投票阶段
         */
        for (int num : nums) {
            //先投票
            if (cand == num) {
                count++;
                continue;
            }

            //重新选择优胜者
            if (count == 0) {
                cand = num;
                count++;
            }

            count--;

        }

        /**
         * 计票阶段
         */
        count = 0;
        for (int num : nums) {
            if (num == cand)
                count++;
        }

        return count > nums.length / 2 ? cand : -1;
    }

    public static void main(String[] args) {
        FindMajorityElementLcci findMajorityElementLcci = new FindMajorityElementLcci();

        int result = findMajorityElementLcci.majorityElement(new int[]{3,2});

        System.out.println(result);
    }
}
