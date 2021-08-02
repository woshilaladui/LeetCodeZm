package com.whut.algorithm.high.frequence.offer.problem_offer_53_2_que_shi_de_shu_zi_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/2 21:58
 * @desription
 */
public class QueShiDeShuZiLcof {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == mid) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {

    }
}
