package com.whut.daily5;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/9/18 15:08
 * @desription
 */
public class Problem11 {

    public static void main(String[] args) {

//        int []height = new int[]{1,8,6,2,5,4,8,3,7};
//
//        System.out.println(maxArea(height));

        System.out.println(Integer.MAX_VALUE);

    }

    public static int maxArea(int[] height) {

        if(height.length<=1)
            return 0;

        int leftPos = 0;
        int rightPos = height.length - 1;

        int max = 0;
        int curentAres;

        while (leftPos < rightPos){

            curentAres = (rightPos - leftPos) * Math.min(height[leftPos],height[rightPos]);

            if(max < curentAres)
                max = curentAres;

            if(height[leftPos] < height[rightPos])
                leftPos ++;
            else
                rightPos --;


        }

        return max;

    }
}
