package com.whut.algorithm.backTrack.test;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/30 14:48
 * @desription
 */
public class BackTrackTest {

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();

        LinkedList<Integer> path = new LinkedList<>();

        backTrack(0,nums,result,path);

        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }

        return result;

    }

    private static void backTrack(int start,int[] nums,List<List<Integer>> result,LinkedList<Integer> path){

        //将新的path加入result中
        result.add(new LinkedList<>(path));


        for(int i= start;i<nums.length;i++){

            path.add(nums[i]);

            backTrack(i+1,nums,result,path);


            path.removeLast();


        }


    }

    public static void main(String[] args) {

//        int[] nums = new int[]{1,2,3};
//
//        subsets(nums);

        int oldCapacity = 10;

        int newCapacity = oldCapacity + (oldCapacity >> 1);

        System.out.println(newCapacity);

        ArrayList list = new ArrayList();

    }
}
