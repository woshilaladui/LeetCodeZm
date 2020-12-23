package com.whut.daily6.problem16;

import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/9/21 19:03
 * @desription
 */
public class Problem16 {

    public static void main(String[] args) {


        int []nums =new int[]{-1,1,2,-4};
        int target = 1;

        System.out.println(threeSumClosest(nums,target));

    }


    //暴力
    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int temp;
        int min=Integer.MAX_VALUE;
        int result;
        int ii = 0,jj=0,kk=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                temp=nums[i]+nums[j];
                for(int k=nums.length-1;k>j;k--){
                    result=temp+nums[k];
                    if(min>Math.abs(result-target)){
                        ii=i;
                        jj=j;
                        kk=k;
                        min=Math.abs(result-target);
                    }



                }



            }
        }


        // System.out.print("    最终"+(nums[ii]+nums[jj]+nums[kk]));
        return nums[ii]+nums[jj]+nums[kk];


    }

    //采用二分来查找
    /**
     * 3个指针
     *
     * i start end
     *
     * start = i +1
     * end = length -1
     *
     */
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++){
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                int sum = nums[i] + nums[start] + nums[end];
                if(Math.abs(sum-target)<Math.abs(ans-target))
                    ans = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }

}
