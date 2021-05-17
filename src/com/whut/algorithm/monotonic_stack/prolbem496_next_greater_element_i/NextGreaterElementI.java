package com.whut.algorithm.monotonic_stack.prolbem496_next_greater_element_i;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/13 20:38
 * @desription
 */
public class NextGreaterElementI {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums2.length;

        Stack<Integer> stack = new Stack<>();

        Map<Integer,Integer> map = new HashMap<>();

        int[] res = new int[nums1.length];

        for(int i=n-1;i>=0;i--){

            //个子矮的出栈
            while(!stack.empty() && stack.peek()<=nums2[i]){
                stack.pop();
            }
            map.put(nums2[i],stack.empty() ? -1 : stack.peek());

            //自己入栈
            stack.push(nums2[i]);
        }

        for(int i=0;i<nums1.length;i++){
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};

        int[] res = nextGreaterElement(nums1,nums2);
        for (int re : res) {
            System.out.print(re+" ");
        }
    }
}
