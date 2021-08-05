package com.whut.algorithm.high.frequence.common.problem287_find_the_duplicate_number;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/23 10:13
 * @desription
 */
public class FindTheDuplicateNumber {

    /**
     * 注意题目条件 n+1 个数字 x在[1,n]之间
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while(true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(fast == slow)
                break;
        }

        //慢指针从头开始
        slow = 0;

        while(true){
            fast = nums[fast];
            slow = nums[slow];
            if(slow == fast)
                break;
        }
        return slow;

//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                map.put(num, map.get(num) + 1);
//            } else {
//                map.put(num, 1);
//            }
//        }
//
//        for (Integer key : map.keySet()) {
//            if (map.get(key) >= 2)
//                return key;
//        }
//        return 0;
    }

    public static void main(String[] args) {
        int []nums = new int[]{1,2,9,9,3};

        System.out.println(findDuplicate(nums));
    }
}
