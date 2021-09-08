package com.whut.algorithm.high.frequence.list;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/31 9:20
 * @desription
 */
public class TrainQukilySort {
    public static void main(String[] args) {
        int []nums = new int[]{2,5,1,4,6};

        qukilySort(nums,0,nums.length-1);

        for (int num : nums) {
            System.out.print(num+" ");
        }
    }

    public static int partion(int []A,int low,int high){
        int privot = A[low];

        while (low < high){
            while (low < high && privot <= A[high]){
                high--;
            }

            A[low] = A[high];

            while (low < high && privot >= A[low])
                low++;

            A[high] = A[low];
        }

        A[low]  = privot;

        return low;

    }

    private static void qukilySort(int []A,int low,int high){
        if(low <= high){
            int part = partion(A,low,high);
            qukilySort(A,low ,part-1);
            qukilySort(A,part+1,high);
        }
    }
}
