package com.whut.algorithm.high.frequence.offer.problem_offer_11_xuan_zhuan_shu_zu_de_zui_xiao_shu_zi_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/23 11:04
 * @desription
 */
public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int mid = 0;

        while (left <= right) {
            if (nums[left] < nums[right])
                return nums[left];

            mid = left + (right - left) / 2;

            if (nums[mid] == nums[left]) {
                //跳过重复元素
                left++;
            } else if (nums[mid] > nums[left]) {
                //说明区间有序，递增,最小值不可能在这里出现
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[mid];
    }

    public int minArray1(int[] numbers) {

        int left = 0;
        int right = numbers.length - 1;

        int minIndex = left;

        /**
         * 防止 1 2 3 4 5 这样顺序数组出现，第一个就是最小值
         */
        while (numbers[left] >= numbers[right]) {

            if (right - left == 1) {
                //当遍历到，num1 数组最后一个元素，num2数组第一个元素则 num2数组第一个元素就是最小值
                minIndex = right;
                break;
            }

            minIndex = left + (right - left) / 2;

            /**
             *
             * 出现如下情况，无法判断最小值在num1,还是num2，所以采取顺序查找
             * 1 0 1 1 1
             * 1 1 1 0 1
             *
             */
            if (numbers[left] == numbers[minIndex] && numbers[right] == numbers[minIndex]) {
                return mindInOrder(numbers, left, right);
            } else if (numbers[left] <= numbers[minIndex]) {
                //3 4 5 0 1 2
                //说明最小值在num2中
                //所以left 不管怎么遍历都会在num1数组中
                left = minIndex;
            } else {
                //numbers[right] >= numbers[minIndex]
                //否则在后面数组中
                right = minIndex;
            }

        }

        return numbers[minIndex];
    }

    public int mindInOrder(int[] num, int left, int right) {
        int result = num[left];

        for (int i = left + 1; i <= right; i++) {
            if(num[i] <result)
                result = num[i];
        }
        return result;
    }

    public static void main(String[] args) {
        XuanZhuanShuZuDeZuiXiaoShuZiLcof xuanZhuanShuZuDeZuiXiaoShuZiLcof = new XuanZhuanShuZuDeZuiXiaoShuZiLcof();

        System.out.println(xuanZhuanShuZuDeZuiXiaoShuZiLcof.minArray1(new int[]{3,4,5,0,1,2}));
    }
}
