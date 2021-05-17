package com.whut.algorithm.common.swap_numbers_lcci;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/24 17:17
 * @desription
 */
public class SwapNumbersLcc {

    /**
     * 不用任何辅助空间
     * @param numbers
     * @return
     */
    public int[] swapNumbers(int[] numbers) {


        //[0,2147483647]
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];

        return numbers;
    }

    public static void main(String[] args) {

    }
}
