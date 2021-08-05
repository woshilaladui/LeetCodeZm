package com.whut.algorithm.high.frequence.common.problem5_longest_palindromic_substring;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/11 13:34
 * @desription
 */
public class Test {

    public static void main(String[] args) {
        int []a = new int[]{1,2,3,4,5};

        int left = 0 ,right = a.length-1;

        while (left < right){
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }

        for (int i : a) {
            System.out.print(i+",");
        }
    }
}
