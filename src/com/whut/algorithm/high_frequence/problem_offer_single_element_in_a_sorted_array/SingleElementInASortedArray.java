package com.whut.algorithm.high_frequence.problem_offer_single_element_in_a_sorted_array;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/14 10:36
 * @desription
 */
public class SingleElementInASortedArray {

    //只出现一次的数字

    /**
     *
     * 1. a ⊕ 0 = a
     * 2. a ⊕ a = 0
     * 3. a ⊕ b ⊕ a = a ⊕ a ⊕ b = 0 ⊕ b = b
     *
     * > 所以1,1,2,3,3,4,4,8,8 中只出现一次
     * a1 ⊕ a1 ⊕ a2 ⊕ a2 ⊕ a3 ⊕ a3 ⊕ a4 = a4
     *
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    /**
     * 详情见图片
     * @param nums
     * @return
     */
    public static int singleNonDuplicate_binary(int[] nums) {

        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            //判断奇数区域在左边high的变化，和在右边low的变化
            boolean halvesAreEven = mid % 2 == 0;

            if(nums[mid + 1] == nums[mid]){
                if(halvesAreEven){
                    low = mid + 2;
                }else {
                    high = mid - 1;
                }
            }else if(nums[mid -1] == nums[mid]) {
                if(halvesAreEven){
                    high = mid - 2;
                }else {
                    low = mid + 1;
                }
            }else {
                return nums[mid];
            }
        }

        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate_binary(new int[]{1,1,2}));
    }
}
