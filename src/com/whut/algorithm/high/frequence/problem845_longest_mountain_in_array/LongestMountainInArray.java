package com.whut.algorithm.high.frequence.problem845_longest_mountain_in_array;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/18 9:40
 * @desription
 */
public class LongestMountainInArray {

    private static int longestMountain2(int []arr){

        int n = arr.length;

        if(n < 2)
            return 0;

        int left = 0;

        int result = 0;

        //left + 2 < n 保证至少有三个数字
        while (left + 2 < n){
            int right = left + 1;
            if(arr[left] < arr[left+1]){
                //保证上升阶段至少有两个数
                while (right+1 < n && arr[right] < arr[right+1]){
                    right++;
                }

                if(right +1 < n && arr[right] > arr[right + 1]){
                    while (right + 1 < n && arr[right] > arr[right + 1]){
                        right++;
                    }
                    result = Math.max(result,right -left + 1);
                }else {
                    right++;
                }
            }
            left = right;
        }
        return result;

    }

    public static int longestMountain1(int[] arr) {

        int n = arr.length;

        if(n < 2)
            return 0;

        int i = 1;

        int result = 0;

        while (i < n){
            int increasing = 0,decreasing = 0;
            //上升阶段
            while (i < n && arr[i-1] < arr[i]){
                i++;
                increasing++;
            }

            while (i < n && arr[i-1] > arr[i]){
                i++;
                decreasing++;
            }

            if(increasing > 0 && decreasing > 0){
                result = Math.max(result,increasing + decreasing + 1);
            }

            //           i-1  i
            //排除平层 2  5   5 2

            while (i < n && arr[i-1] == arr[i])
                i++;

        }

        return result;
    }

    public static void main(String[] args) {
        int []arr = new int[]{2,1,4,7,3,2,5};

        System.out.println(longestMountain2(arr));
    }

}
