package com.whut.algorithm.high.frequence.offer.problem_offer_61_bu_ke_pai_zhong_de_shun_zi_lcof;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/7 16:17
 * @desription
 */
public class BuKePaiZhongDeShunZiLcof {

    public boolean isStraight1(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);

        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0)
                joker++;//统计大王出现次数
            else if (nums[i] == nums[i + 1])
                //有重复则构不成顺子
                return false;
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return nums[4] - nums[joker] < 5;
    }

    public boolean isStraight2(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if (repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

    public static void main(String[] args) {

    }

}
