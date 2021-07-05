package com.whut.algorithm.high.frequence.offer.problem_offer_21_diao_zheng_shu_zu_shun_xu_shi_qi_shu_wei_yu_ou_shu_qian_mian_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/22 14:32
 * @desription
 */
public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {

    public static int[] exchange(int[] nums) {

        int left = 0, right = nums.length - 1;

        while (left < right) {
            //left指向从前往后找偶数
            while (left < right && nums[left] % 2 != 0)
                left++;
            //right指向从后往前扫描找到奇数
            while (left < right && nums[right] %2 == 0)
                right--;

            if(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }

//        int left = 0, right = 0;
//
//
//        while ( right < nums.length-1) {
//            //找到第一个偶数位置
//            while (nums[left] % 2 != 0 && left < nums.length-1) {
//                if(left == right){
//                    left++;
//                    right++;
//                }else {
//                    left++;
//                }
//
//            }
//
//            //找到第一个奇数位置
//            while (nums[right] % 2 == 0 && right < nums.length - 1) {
//                right++;
//            }
//
//            int temp = nums[left];
//            nums[left] = nums[right];
//            nums[right] = temp;
//
//        }
//
////        for (int num : nums) {
////            System.out.print(num + " ");
////        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1};
        //[2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1]

        exchange(nums);
    }
}
