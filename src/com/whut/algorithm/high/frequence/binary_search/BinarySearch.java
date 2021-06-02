package com.whut.algorithm.high.frequence.binary_search;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/21 14:59
 * @desription
 */
public class BinarySearch {


    private static int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    private static int right_binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        //防止right过界
        if (right < 0 || nums[right] != target)
            return -1;

        return right;
    }

    private static int left_binary_search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                right = mid - 1;

        }


        //检查left是否过界
        if (left >= nums.length || nums[left] != target)
            return -1;

        return left;
    }

    private static int left_binary_search2(int[] nums, int target) {

        int left = 0, right = nums.length;

        while (left < right) {

            int mid = (left+right)/2;
            System.out.println("mid = " + mid);
            if (nums[mid] > target) {
                right = mid;
            }else if(nums[mid] <target){
                left = mid+1;
            }else {
                //往左靠
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 15, 16, 17, 17, 17, 17, 19, 22, 100, 101, 114};

        System.out.println(left_binary_search(nums, 17));

    }

}
