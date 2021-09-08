package com.whut.interview.fenghuo.problem2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/4 19:46
 * @desription
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] nums = new int[n];
        int []nums = new int[]{2,3,5,5,7,12,51};
//        for (int i = 0; i < n; i++) {
//            nums[i] = scanner.nextInt();
//        }
        System.out.println(getExposed(nums));
    }

    private static int getExposed(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i; j >= 0; j--){
                if(nums[j] !=0 && nums[j]*3 <= nums[i]){
                    n--;
                    nums[j] = 0;
                    break;
                }
            }
        }
        return n;
//        int count = 1;
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] * 3 <= nums[i + 1]){
//                i++;
//                count++;
//                continue;
//            }
//
//            count++;
//        }
//        return count;
    }
}
