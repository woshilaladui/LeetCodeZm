package com.whut.algorithm.high.frequence.offer.problem_offer_17_10_find_majority_element_lcci;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/24 15:18
 * @desription
 */
public class FindMajorityElementLcci {


    public int majorityElement1(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        int major = -1;

        for (Map.Entry entry : map.entrySet()) {
            if((int)entry.getValue() > nums.length/2)
                major = (int)entry.getKey();
        }

        return major;
    }

    /**
     * 输入：[1,2,5,9,5,9,5,5,5]
     * 输出：5
     * <p>
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
         * 判断票数是否满足要求
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

        //
        int result = findMajorityElementLcci.majorityElement1(new int[]{3,2,3});

        System.out.println(result);
    }
}
