package com.whut.algorithm.high.frequence.offer.problem_offer_45_ba_shu_zu_pai_cheng_zui_xiao_de_shu_lcof;

import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/27 21:08
 * @desription
 */
public class BaShuZuPaiChengZuiXiaoDeShuLcof {

    /**
     * 若拼接字符串 x + y > y + x 则  x '大于' y
     *
     *  在排序后应该x 在y 右边
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        //将 nums数组转成str数组
        String[] strs = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        quiklySort(strs, 0, nums.length - 1);

        StringBuilder sb = new StringBuilder();

        Arrays.stream(strs).forEach(sb::append);

        return sb.toString();
    }

    private void quiklySort(String[] strs, int low, int high) {
        if (low <= high) {
            int pivotLoc = partion(strs, low, high);

            quiklySort(strs, low, pivotLoc - 1);
            quiklySort(strs, pivotLoc + 1, high);
        }
    }

    private int partion(String[] strs, int low, int high) {
        String pivotKey = strs[low];

        while (low < high) {

            while (low < high && (strs[high] + pivotKey).compareTo(pivotKey + strs[high]) >= 0)
                high--;

            strs[low] = strs[high];

            while (low < high && (strs[low] + pivotKey).compareTo(pivotKey + strs[low]) <= 0)
                low++;

            strs[high] = strs[low];
        }

        strs[low] = pivotKey;

        return low;

    }


    public static void main(String[] args) {
        BaShuZuPaiChengZuiXiaoDeShuLcof baShuZuPaiChengZuiXiaoDeShuLcof = new BaShuZuPaiChengZuiXiaoDeShuLcof();

        int[] nums = new int[]{3, 32, 321};

        System.out.println(baShuZuPaiChengZuiXiaoDeShuLcof.minNumber(nums));
    }
}
