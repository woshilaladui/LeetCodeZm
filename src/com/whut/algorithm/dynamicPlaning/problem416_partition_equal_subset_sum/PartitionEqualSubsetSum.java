package com.whut.algorithm.dynamicPlaning.problem416_partition_equal_subset_sum;

import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/25 16:43
 * @desription
 */
public class PartitionEqualSubsetSum {

    private static boolean doCanPartition3(int[] nums){
        int sum = Arrays.stream(nums).sum();

        if(sum % 2 != 0)
            return false;
        else
            sum/=2;

        //压缩数组
        boolean[] dp = new boolean[sum+1];

        dp[0] = true;

        for(int i=0;i<nums.length;i++){
            for(int j=sum;j>=1;j--){
                if(j>=nums[i])
                    //类式0/1背包 只能取一次，所以从后往前扫描
                    //dp[i][j] = dp[i-1][j]||dp[i-1][j-nums[i]];
                    dp[j] = dp[j]||dp[j-nums[i]];
            }
        }

        return dp[sum];

    }

    private static boolean doCanPartition2(int[] nums){

        int sum = Arrays.stream(nums).sum();

        if(sum % 2 != 0)
            return false;
        else
            sum/=2;

        //压缩数组
        boolean[] dp = new boolean[sum+1];

        dp[0] = true;

        for(int i=1;i<=nums.length-1;i++){
            for(int j=sum;j>=1;j--){
                if(j>=nums[i])
                    //类式0/1背包 只能取一次，所以从后往前扫描
                    //dp[i][j] = dp[i-1][j]||dp[i-1][j-nums[i]];
                    dp[j] = dp[j]||dp[j-nums[i]];
            }
        }


        return dp[sum];
    }


    private static boolean doCanPartition(int[] nums){
        int sum = Arrays.stream(nums).sum();

        if(sum % 2 != 0)
            return false;
        else
            sum/=2;

        //代表前i个组成j的可能性
        boolean[][] dp= new boolean[nums.length][sum+1];

        //初始化 临界值
        for (int i = 0; i <= nums.length-1; i++) {
            //前i个数组成0的可能性，不选择即可，即为true
            dp[i][0] = true;
        }

        for(int i=1;i<=nums.length-1;i++){
            for(int j=1;j<=sum;j++){

                if(j>=nums[i])//放的下
                    //前i-1个的可能性+选择nums[i]的可能性
                    //有重复数据，相当与完全背包
                    dp[i][j] = dp[i-1][j]||dp[i-1][j-nums[i]];
                else
                    //放不下
                    dp[i][j] = dp[i-1][j];

            }
        }

        return dp[nums.length-1][sum];
    }

    /**
     * 二维数组压缩
     * @param nums
     * @return
     */
    private static boolean canPartition2(int[] nums){

        int[] tempNum = new int[nums.length+1];

        for (int i = 1; i <= nums.length; i++)
            tempNum[i] = nums[i - 1];

        for(int i=0;i<tempNum.length;i++)
            System.out.print(tempNum[i]+" ");


        return doCanPartition(tempNum);

    }

    public static boolean canPartition(int[] nums) {


//        int sum = Arrays.stream(nums).sum();
//
//        if (sum % 2 != 0) {
//            return false;
//        } else {
//            sum = sum / 2;
//        }
//
//        boolean[][] dp = new boolean[nums.length][sum + 1];
//
//        //确定状态---d[i][j]表示从前i个数字中，是否能组成j
//        //转移方程---d[i][j] = d[i-1][j] || d[i - 1][j - nums[j]]
//        //d[i-1][j]为不选取nums[i]的情况，即前i-1个元素也可以组成j
//        //d[i-1][j - nums[i]]则是选取nums[i]的情况,即前i-1个元素组成j-nums[i],加上nums[i]后组成j
//        //边界条件---d[i][0] = true  d[0][nums[0]] = true
//        for (int i = 0; i < nums.length; i++) {
//            dp[i][0] = true;
//        }
//
//        for (int i = 0; i < dp.length - 1; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                dp[i + 1][j] =
//                        j - nums[i] >= 0 ? dp[i][j] || dp[i][j - nums[i]] : dp[i][j];
//            }
//        }

//        for(int i=0;i<dp.length-1;i++){
//            for(int j=0;j<dp[0].length;j++){
//                System.out.print("dp["+i+"]["+j+"] = "+dp[i][j]+"   ");
//            }
//            System.out.println();
//        }
//
//        return dp[nums.length - 1][sum];


//        if(nums.length <2){
//            return false;//只有一个元素
//        }
//
//        int length = nums.length;
//        int sum = 0;
//        int max = 0;
//        //总和和最大元素值
//        for(int i = 0;i<length;i++){
//            sum += nums[i];
//            max = Math.max(max,nums[i]);
//        }
//        //如果总和为奇数，则不可能对半分
//        if(sum %2 != 0){
//            return false;
//        }
//
//        int target = sum/2;
//        if(max > target){
//            //最大元素大于总和的一半
//            return false;
//        }
//
//        //确定状态---d[i][j]表示从前i个数字中，是否能组成j
//        //转移方程---d[i][j] = d[i-1][j] || d[i - 1][j - nums[j]]
//        //d[i-1][j]为不选取nums[i]的情况，即前i-1个元素也可以组成j
//        //d[i-1][j - nums[i]]则是选取nums[i]的情况,即前i-1个元素组成j-nums[i],加上nums[i]后组成j
//        //边界条件---d[i][0] = true  d[0][nums[0]] = true
//        boolean[][] f = new boolean[length][target + 1];
//        f[0][nums[0]] = true;
//        f[0][0] = true;
//        for(int i =1;i<length;i++){
//            for(int j = 0;j<=target;j++){
//                if(j==0){
//                    f[i][0] = true;
//                }else{
//                    //当放的下nums[i]时
//                    if(j>=nums[i]){
//                        f[i][j] = f[i-1][j] || f[i - 1][j - nums[i]];
//                    }else{
//                        //当j < nums[i]时，只能看前i-1个数是否能凑出j来
//                        f[i][j] = f[i-1][j];
//                    }
//                }
//            }
//        }
//
//        for(int i=0;i<f.length;i++){
//            for(int j=0;j<f[0].length;j++){
//                System.out.print("dp["+i+"]["+j+"] = "+f[i][j]+"   ");
//            }
//            System.out.println();
//        }
//
//        return f[length-1][target];

        int sum = Arrays.stream(nums).sum();

        if(sum % 2 != 0)
            return false;
        else
            sum/=2;

        boolean[][] dp= new boolean[nums.length][sum+1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for(int i=0;i<nums.length-1;i++){

            for(int j=0;j<=sum;j++){

                //放的下
                //有重复数据相当与完全背包问题
                if(j>=nums[i]){
                    dp[i+1][j] = dp[i][j] || dp[i][j-nums[i]];
                }else {
                    dp[i+1][j] = dp[i][j];
                }

            }

        }

        return dp[nums.length-1][sum];

    }

    public static void main(String[] args) {

        int[] nums= new int[]{1,2,5};

        System.out.println(doCanPartition3(nums));

    }

}
