package com.whut.algorithm.high.frequence.problem_offer_03_shu_zu_zhong_zhong_fu_de_shu_zi_lcof;

import java.util.LinkedList;
import java.util.List;

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
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {

        int slow = 0;
        int fast = 0;

        while (true){
            fast = nums[nums[fast]];
            slow = nums[slow];

            if(slow == fast)
                break;
        }

        //慢指针回到起点
        slow = 0;

        while (true){
            fast = nums[fast];
            slow = nums[slow];

            if(slow == fast)
                break;

        }

        return nums[slow];
    }
}
