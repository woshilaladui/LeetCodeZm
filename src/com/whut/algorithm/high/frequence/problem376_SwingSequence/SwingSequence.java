package com.whut.algorithm.high.frequence.problem376_SwingSequence;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/11/9 15:01
 * @desription
 */
public class SwingSequence {

    public static int wiggleMaxLength(int[] nums) {

        if(nums.length < 2)
            return nums.length;

        final int BEGIN = 0;
        final int UP = 1;
        final int DOWN = 2;

        int STATE = BEGIN;
        int maxLength = 1;

        //从第二个数字开始扫描
        for (int i=1; i< nums.length;i++){

            switch (STATE){

                case BEGIN:
                    if(nums[i-1] > nums[i]){
                        STATE = DOWN;
                        maxLength++;
                    }else if(nums[i-1] < nums[i]){
                        STATE = UP;
                        maxLength++;
                    }
                    break;
                case UP:
                    //当状态发生改变的时候转移
                    /**
                     * 但是不是选择i这个数字作为最终的数字
                     * 只是将状态转移给元素最大的元素中
                     */
                    if(nums[i-1] > nums[i]){
                        STATE = DOWN;
                        maxLength++;
                    }
                    break;
                case DOWN:
                    if(nums[i-1] < nums[i]){
                        STATE = UP;
                        maxLength++;
                    }
                    break;
            }

        }


        return maxLength;

    }

    public static void main(String[] args) {

        int[] num = new int[]{1,17,5,10,13,15,10,5,16,8};

        System.out.println(wiggleMaxLength(num));

    }
}
