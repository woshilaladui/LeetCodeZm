package com.whut.algorithm.high.frequence.backTrack.problem77_combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/30 15:02
 * @desription
 */
public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();

        backTrack(n,k,1,result,path);


        return result;
    }

    private static void backTrack(int n,int k,int start,List<List<Integer>> result,LinkedList<Integer> path){

        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }

        //从start 开始，避免重复子集
        for(int i = start;i<=n;i++){
            path.addLast(i);
            backTrack(n,k,i+1,result,path);
            path.removeLast();

        }

    }

    public static void main(String[] args) {
        int n = 4,k = 2;
        combine(n,k);
    }
}
