package com.whut.algorithm.high.frequence.divide_and_conquer.problem493_reverse_pairs;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/28 10:54
 * @desription
 */
public class ReversePairs {

    /**
     * 思路和 offer51差不多 归并排序
     *
     * 区间问题都可以用归并排序
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return reversePairs(nums, 0, nums.length - 1, temp);
    }

    public int reversePairs(int[] nums, int low, int high, int[] temp) {

        if (low == high)
            return 0;

        int mid = low + (high - low) / 2;

        int left = reversePairs(nums, low, mid, temp);
        int right = reversePairs(nums, mid + 1, high, temp);

        return left + right + merge(nums, low, mid, high, temp);
    }

    private int merge(int[] nums, int low, int mid, int high, int[] temp) {
        //统计结果
        int result = 0;

        for (int i = low; i <= high; i++)
            temp[i] = nums[i];

        int i = low, j = mid + 1, k;

        //做统计
        while (i <= mid) {
            //强转为Long防止越界
            /**
             * (long)(nums[j] * 2) ->越界 nums[j] * 2先越界
             * 2 * (long) (nums[j])
             */
            while (j <= high && (long) nums[i] > 2 * (long) (nums[j])) {
                j++;
            }
            //画图理解
            /**
             *
             * left         right
             * 1 5 9        1 2 4
             *    mid           j
             *
             * 结果为 1 2
             * j - mid - 1
             */
            result += j - mid - 1;

            i++;
        }//end while

        for (i = low, j = mid + 1, k = low; i <= mid && j <= high; k++) {
            if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }

        while (i <= mid)
            nums[k++] = temp[i++];

        while (j <= high)
            nums[k++] = temp[j++];

        return result;
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();

        // (long) (nums[j] * 2)
        int a = 2147483647;
        // a * 2 先越界
        System.out.println((long) (a * 2));
        System.out.println((long) a * 2);


        //[2147483647,2147483647,2147483647,2147483647,2147483647,2147483647]

        System.out.println(reversePairs.reversePairs(new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}));
    }
}
