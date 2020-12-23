package com.whut.daily5.problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/9/18 17:42
 * @desription
 */
public class Problem15 {

    public static void main(String[] args) {

       // int []nums = new int[]{-1, 0, 1, 2, -1, -4} ;
        int []nums = new int[]{0,0,0} ;

        System.out.println(threeSum(nums).toString());

    }

    public static List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> result = new ArrayList<>();

        if(nums.length < 3)
            return result;

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){

            //排序后如果第一个数都比0大就没有结果集
            if(nums[i] > 0)
                break;

            //跳过重复的数字
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;

            /**
             * 找 [i, left, right] which sum to 0
             */
            while ( left < right){

                //相当于2分查找
                List<Integer> temp = new ArrayList<>();

                if(nums[left] + nums[right] + nums[i] == 0){
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);

                    //跳过重复项
                    while (nums[left] == nums[left + 1]) {
                        left++;
                        if(left >= nums.length -1)
                            break;
                    }
                    left++;

                    //跳过重复项
                    while (nums[right] == nums[right - 1]) {
                        right--;
                        if(right <= 1)
                            break;
                    }
                    right--;
                    continue;

                }else if(nums[left] + nums[right] + nums[i] > 0){
                    right--;
                }else {
                    left++;
                }

            }//end while

        }



        return result;

    }

}
