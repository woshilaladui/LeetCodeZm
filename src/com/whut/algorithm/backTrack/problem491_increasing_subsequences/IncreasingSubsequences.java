package com.whut.algorithm.backTrack.problem491_increasing_subsequences;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/6 19:28
 * @desription
 */
public class IncreasingSubsequences {

    private static int maxLength = 0;
    private static int maxNums = 0;

    public static List<List<Integer>> findSubsequences(int[] nums) {

        List<List<Integer>> resultList = new ArrayList();
        if(nums == null || nums.length == 0) return resultList;
        backTrack(resultList,new ArrayList<Integer>(),nums,0);

        for (List<Integer> list : resultList) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();

        }

        return resultList;

    }

    private static void backTrack(
            List<List<Integer>> resultList,
            List<Integer> subList,
            int[] nums,
            int start
    ) {

        if(subList.size() >1){

            if(subList.size()>maxLength){
                maxLength = subList.size();
                maxNums = 0;
            }
            if(subList.size() == maxLength)
                maxNums++;

            resultList.add(new ArrayList<>(subList));
        }
        //去重剪纸 去重见图片
        //https://blog.csdn.net/youngyangyang04/article/details/110095113?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522160725759919724813277796%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=160725759919724813277796&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~rank_v29-2-110095113.first_rank_v2_pc_rank_v29&utm_term=%E5%9B%9E%E6%BA%AF%E7%AE%97%E6%B3%95%E5%8E%BB%E9%87%8D&spm=1018.2118.3001.4449
        Set<Integer> set = new HashSet<>();
        for(int i = start;i<nums.length;i++){
            if(!set.contains(nums[i]) && (subList.size() == 0 || nums[i] >= subList.get(subList.size()-1)) ){
                set.add(nums[i]);
                subList.add(nums[i]);
                backTrack(resultList,subList,nums,i+1);
                subList.remove(subList.size()-1);
            }
        }
    }


    public static void main(String[] args) {

        //int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1};
        int[] nums = new int[]{4,6,7,7};

        //[][]
        //Arrays.sort(nums);

        findSubsequences(nums);

    }

}
