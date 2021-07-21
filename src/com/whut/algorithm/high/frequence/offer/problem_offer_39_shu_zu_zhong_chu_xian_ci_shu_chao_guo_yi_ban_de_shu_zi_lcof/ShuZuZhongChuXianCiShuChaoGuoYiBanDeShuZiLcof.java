package com.whut.algorithm.high.frequence.offer.problem_offer_39_shu_zu_zhong_chu_xian_ci_shu_chao_guo_yi_ban_de_shu_zi_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/21 21:24
 * @desription
 */
public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {
    public int majorityElement(int[] nums) {

        int cand1 = nums[0];
        int count1 = 0;

        for (int num : nums) {
            //投票阶段
            if (num == cand1) {
                count1++;
                continue;
            }

            //如果投的人不是can1

            //再选谁是优胜者,票数为0要更换cand
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }

            count1--;

        }

//        //计票阶段
//        count1 = 0;
//        for (int num : nums) {
//            if(num == count1)
//        }

        return cand1;
    }

    public static void main(String[] args) {

    }
}
