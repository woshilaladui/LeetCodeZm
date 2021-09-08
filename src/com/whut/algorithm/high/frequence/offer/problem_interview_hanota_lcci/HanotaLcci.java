package com.whut.algorithm.high.frequence.offer.problem_interview_hanota_lcci;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/3 20:23
 * @desription
 */
public class HanotaLcci {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

    }


    private static void movePlant(int size, List<Integer> start, List<Integer> temp, List<Integer> target) {
        if (1 == size){
            //只剩一个的时候，就把他从第一个柱子移动到第三个柱子
            target.add(start.remove(start.size()-1));
            return;
        }
        //将n-1个盘子从第一个柱子通过第三个
//        movePlant();
    }

    public static void main(String[] args) {

    }
}
