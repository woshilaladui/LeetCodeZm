package com.whut.algorithm.high.frequence.offer.problem_offer_38_zi_fu_chuan_de_pai_lie_lcof;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/16 10:34
 * @desription
 */
public class ZiFuChuanDePaiLieLcof {

    /**
     * 联系排列组合类型的题目
     * @param s
     * @return
     */
    public String[] permutation(String s) {

        char[] sArray = s.toCharArray();

        List<String> result = new LinkedList<>();
        StringBuilder path = new StringBuilder();
        boolean[] vis = new boolean[sArray.length];

        backTrack(sArray,result,path,vis);

        return result.toArray(new String[result.size()]);
    }

    private void backTrack(
            char[] sArray,
            List<String> result,
            StringBuilder path,
            boolean[] vis
    ) {
        //递归结束
        if (path.length() == sArray.length) {
            result.add(path.toString());
            return;
        }

        //set 只管递归的这一层，所以回溯不需要手动移除
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < sArray.length; i++) {

            if(set.contains(sArray[i]) || vis[i]){
                continue;
            }

            set.add(sArray[i]);
            vis[i] = true;
            path.append(sArray[i]);
            backTrack(sArray,result,path,vis);
            path.deleteCharAt(path.length()-1);
            vis[i] = false;

        }
    }

    public static void main(String[] args) {
        ZiFuChuanDePaiLieLcof ziFuChuanDePaiLieLcof = new ZiFuChuanDePaiLieLcof();

        String[] result = ziFuChuanDePaiLieLcof.permutation("aba");

        for (String s : result) {
            System.out.println(s);
        }

    }
}
